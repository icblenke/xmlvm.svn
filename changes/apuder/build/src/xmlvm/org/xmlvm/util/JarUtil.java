package org.xmlvm.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.xmlvm.Main;

public class JarUtil {

	static public void copy(String fromJar, String toPath) {
		try {
			JarInputStream libFiles = new JarInputStream(Main.class
					.getResourceAsStream(fromJar));
			if (!toPath.endsWith(File.separator))
				toPath += File.separator;
			File dir = new File(toPath);
			if (!dir.exists())
				dir.mkdirs();
			JarEntry file = null;
			while ((file = libFiles.getNextJarEntry()) != null) {
				final int BUFFER = 2048;
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream(toPath
						+ file.getName());
				BufferedOutputStream dest = new BufferedOutputStream(fos,
						BUFFER);
				while ((count = libFiles.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}

	static public BufferedReader getFile(String name) {
		return new BufferedReader(new InputStreamReader(Main.class
				.getResourceAsStream(name)));
	}
}
