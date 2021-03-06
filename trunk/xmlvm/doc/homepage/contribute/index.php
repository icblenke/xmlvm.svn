<?php
  include("../header.html");
  include("../content_top.html");
?>
<h1>Contribute</h1>

<h2 class="title">Making XMLVM better</h2> 

This page is for all developer that are interested in contributing to the XMLVM project. We will explain how you can download the source code, help you understand the current code structure, tell you about our coding guidelines and show you what you need to do if you want to contribute a patch.

<h3>Licensing</h3>
XMLVM is licensed under the <a target="_blank" href="http://www.gnu.org/licenses/gpl-2.0.txt">GPL v2</a><br/><br/>
Those developers who contribute to XMLVM will be granted a linking exception to the GPL that allows them (and only them) to use XMLVM in a commercial product.

<h3>Getting and compiling the source</h3>
Our source code is currently hosted in our Subversion repository at <a target="_blank" href="http://www.sourceforge.net/projects/xmlvm">Sourceforge</a>. In order to check out the code, you need a <a target="_blank" href="http://subversion.tigris.org/">Subversion</a> client. As the team works with <a target="_blank" href="http://www.eclipse.org">Eclipse</a>, our recommendation is to use <a target="_blank" href="http://subclipse.tigris.org/">Subclipse</a>, which is a free Eclipse plugin that allows you to easily checkout and update your code. We would recommend you to install this plugin as well, if you are planning to work with Eclipse.

The root for checking out the code is:

<pre class="code">http://xmlvm.svn.sourceforge.net/svnroot/xmlvm/trunk/xmlvm</pre>

If you want to checkout the code via the Subversion <pre>svn</pre> client, use the following command:

<pre class="code">svn co http://xmlvm.svn.sourceforge.net/svnroot/xmlvm/trunk/xmlvm xmlvm</pre>

<h3>Source code structure</h3>
Once you have checked out the code, you see the following structure:
<ul>
	<li><b><pre>.classpath</pre></b><br/>
	  This file is used by Eclipse to define the classpath entries for XMLVM.
	</li>

	<li><b><pre>.project</pre></b><br/>
	  This file is used by Eclipse and defines the project.
	</li>

	<li><b><pre>.settings/</pre></b><br/>
	  This file is also used by Eclipse and contains presets for the project.
	</li>

	<li><b><pre>LICENSE-GPL</pre></b><br/>
	  This file contains a copy of the GPL license.
	</li>

	<li><b><pre>build.xml</pre></b><br/>
	  This file is used by<pre>ant</pre> to build XMLVM and its components.
	</li>

	<li><b><pre>/demo/</pre></b><br/>
	  This directory contains demos that show what's possible with XMLVM.
	</li>

	<li><b><pre>/doc/</pre></b><br/>
	  This directory contains documentation, our homepage and XMLVM graphics.
	</li>

	<li><b><pre>/etc/</pre></b><br/>
	  Launch files and our style configuration can be found here.
	</li>

	<li><b><pre>/lib/</pre></b><br/>
	  All third-party libraries that XMLVM depends on can be found in this directory.
	</li>

	<li><b><pre>/src/</pre></b><br/>
	  All of XMLVM's source code is found here. See the next section for an explanation of the structure within this directory.
	</li>
</ul>

<h4>The <pre>/src/</pre> directory</h4>
All of XMLVM's main source can be found in this directory. To give you an overview of what can be found in there, here is a high-level overview of the most important directories:
<ul>
	<li><b><pre>android2iphone/</pre></b><br/>
		Contains android compatibility libraries for executing Android code in Objective-C.
	</li>

	<li><b><pre>avm2jvm/</pre></b><br/>
		In here you find our approach to use cross-compilation aspect weaving.
	</li>

	<li><b><pre>clr2jvm/</pre></b><br/>
		This directory has the stylesheet for CLR to JVM cross-compilation as well as the .NET compatibility Library, so .NET programs can be run on a Java VM.
	</li>
		
	<li><b><pre>demo/</pre></b><br/>
		We are currenty in the process of moving all demos to <pre>/demo</pre>.
	</li>
		
	<li><b><pre>jvm2clr/</pre></b><br/>
		This directory has the stylesheet for JVM to CLR cross-compilation as well as a rudimentary compatibility library. 
	</li>
	
	<li><b><pre>test/</pre></b><br/>
		Some code to test existing XMLVM functionality.
	</li>
	
	<li><b><pre>xmlvm/</pre></b><br/>
		This directory contains the XMLVM framework code.
	</li>
	
	<li><b><pre>xmlvm2cpp/</pre></b><br/>
		Contains the stylesheet that produces C++ code as well as a very small compatibility library for Java-based applications.
	</li>
	
	<li><b><pre>xmlvm2js/</pre></b><br/>
		This is the quite mature JavaScript output component of XMLVM. It contains compatibility libraries for a lot of input APIs, including Java, .NET and Android. The stylehseet for generating JavaScript can also be found here.
	</li>
	
	<li><b><pre>xmlvm2objc/</pre></b><br/>
		In here you find the stylesheet that emits Objective-C code as well as our own Java-based iPhone API that we use to develop other compatibility libraries for the iPhone, like the android2iphone API mapping.
	</li>
	
	<li><b><pre>xmlvm2py/</pre></b><br/>
		This directory contains a stylesheet that generates Python code as well as a rudimentary compatibility library for Java/AWT.
	</li>
</ul>


<h3>Coding guidelines</h3>
We try to maintain a consistent coding style throughout our project. We recommend you using Eclipse, as we have created a configuration file that will help you writing code that is compliant with our style. You can find this configuration file in <pre>/etc/xmlvm-style.xml</pre>.
<br/><br/>
To use this file go to your XMLVM project in Eclipse and choose: <pre>Project -> Properties</pre>. From there find <pre>Java Code Style -> Formatter</pre>. Check <pre>Enable project specific settings</pre> and click on <pre>Import...</pre>. Now choose the <pre>xmlvm-style.xml</pre> file and you should be all set.
<br/><br/>
Not everything is covered by these rules. For example, naming variables in a meaningful and compliant way is up to you. So please look around in the rest of the code to get a feel for how you should name classes, members and methods.

<h3>Contributors license agreement</h3>
Before we can accept a patch, you need to sign a Contributor License Agreement.
We need to have a <a href="http://www.xmlvm.org/contribute/cla.php">Contributor License Agreement</a> from you on file. Without it, your code cannot be submitted into the XMLVM repository. You only need to do this once.<br/><br/>
In return we will grant you a GPL linking exception that will enable you to use XMLVM in a commercial product without having to place your own code under the GPL.
<br/><br/>

<h3>Submitting a patch</h3>
Before generating a patch, please first update your local work copy to the latest version of the Subversion repository in order to reduce the risk of conflicts. In Eclipse, right-click on the project name and then select <pre>Team -> Create patch...</pre>. Once you have generated the patch, you have two options to submit it. You can either simply email it to <pre>reviews@xmlvm.org</pre> or you can submit it through a hosted code reviewing tool.
A code review gives us the opportunity to take a close look at your contribution so we can make sure it doesn't contain major bugs and complies with our coding styles.
<br/><br/>
In order to make this process easy, we host a code review portal which you can find here:

<a href="http://xmlvm-reviews.appspot.com/">http://xmlvm-reviews.appspot.com/</a>

In order to submit a patch for code review, you need to have a Google account, you will then be able to log into this portal. Create a new issue for your patch. Give it a meaningful title and descriptions. The "SVN base" that is given should work if you created your patch relative to the SVN root directory mentioned above.<br/><br/>
As reviewer, please add this e-mail address: <pre>reviews@xmlvm.org</pre>. You can then append your patch either directory from a file that you created or via a URL, to which you uploaded the patch. If you have questions on how to create a patch, please let us know

<?php
  include("../footer.html");
?>