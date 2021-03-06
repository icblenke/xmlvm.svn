/*
 * Copyright (c) 2004-2009 XMLVM --- An XML-based Programming Language
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 * 
 * For more information, visit the XMLVM Home Page at http://www.xmlvm.org
 */
package org.xmlvm.proc.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlvm.Log;
import org.xmlvm.main.Arguments;
import org.xmlvm.proc.XmlvmProcessImpl;
import org.xmlvm.proc.out.build.MakeFile;
import org.xmlvm.proc.out.build.XCodeFile;
import org.xmlvm.util.JarUtil;

public class IPhoneOutputProcess extends XmlvmProcessImpl<ObjectiveCOutputProcess> {

    private static final String IPHONE_COMPAT_LIB_JAR  = "/iphone/compat-lib.jar";
    private static final String IPHONE_COMPAT_LIB_PATH = "src/xmlvm2objc/compat-lib/objc";
    private List<OutputFile>    result                 = new ArrayList<OutputFile>();
    public static final String  IPHONE_SRC             = "/src/xmlvm";
    public static final String  IPHONE_SRC_LIB         = IPHONE_SRC + "/lib/iphone";
    public static final String  IPHONE_SRC_APP         = IPHONE_SRC + "/app";
    public static final String  IPHONE_RESOURCES_SYS   = "/resources/sys";
    public static final String  IPHONE_RESOURCES_APP   = "/resources/app";

    public IPhoneOutputProcess(Arguments arguments) {
        super(arguments);
        // Only ObjectiveCOutputProcesses are supported as input.
        addSupportedInput(ObjectiveCOutputProcess.class);
    }

    @Override
    public List<OutputFile> getOutputFiles() {
        return result;
    }

    @Override
    public boolean process() {
        List<ObjectiveCOutputProcess> preprocesses = preprocess();

        Log.debug("Processing IPhoneOutputProcess");

        // Add all the files from the preprocesses to our result list.
        for (ObjectiveCOutputProcess preprocess : preprocesses) {
            for (OutputFile in : preprocess.getOutputFiles()) {
                OutputFile out = new OutputFile(in.getData());
                out.setFileName(in.getFileName());
                out.setLocation(in.getLocation() + IPHONE_SRC_APP);
                result.add(out);
            }
        }

        if (JarUtil.resourceExists(IPHONE_COMPAT_LIB_JAR)) {
            // If the jar exists, we create a new OutputFile instance that will
            // lead in the contents of this file being copied to the
            // destination.
            // This is the typical scenario for when XMLVM is called from within
            // xmlvm.jar.
            FromJarOutputFile compatLibJar = new FromJarOutputFile();
            compatLibJar.setLocation(arguments.option_out() + IPHONE_SRC_LIB);
            compatLibJar.setSourceJar(IPHONE_COMPAT_LIB_JAR);
            result.add(compatLibJar);
        } else {
            // If the jar is not present, we take the file from their actual
            // path and copy them to the destination.
            result.add(new DirectoryCopyOutput(IPHONE_COMPAT_LIB_PATH, arguments.option_out()
                    + IPHONE_SRC_LIB));
        }

        try {
            // Create Info.plist
            // TODO: Copy non-in-JAR file version in case we are not in JAR-file
            // mode.
            BufferedReader infoIn = JarUtil.getFile("/iphone/Info.plist");
            StringBuffer infoOut = new StringBuffer();
            String line = null;
            while ((line = infoIn.readLine()) != null) {
                line = line.replaceAll("XMLVM_APP", arguments.option_app_name());
                infoOut.append(line).append("\n");
            }
            OutputFile infoPlistFile = new OutputFile(infoOut.toString());
            infoPlistFile.setLocation(arguments.option_out() + IPHONE_RESOURCES_SYS);
            infoPlistFile.setFileName(arguments.option_app_name() + "-Info.plist");
            result.add(infoPlistFile);
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        /* Add resources, as defined */
        for (String resourcedir : arguments.option_resource()) {
            List<ResourceOutputFile> resources = ResourceOutputFile.listResources(resourcedir,
                    arguments.option_out() + IPHONE_RESOURCES_APP,
                    arguments.option_out() + IPHONE_SRC_APP
                    );
            result.addAll(resources);
        }

        /* Create various buildfiles */
        MakeFile makefile = new MakeFile();
        Log.error(makefile.composeBuildFiles(result, arguments));
        XCodeFile xcode = new XCodeFile();
        Log.error(xcode.composeBuildFiles(result, arguments));

        return true;
    }
}
