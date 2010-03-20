Applet/Android/IPhone Portable Code
-----------------------------------

This is just a quick snapshot of where I am with this stuff. Build instructions below 
and please remember this isn't really for use unless you already know a fair bit
about what you're doing. There is no support.

Note that the majority of this work is based on the http://www.xmlvm.org project.

There may be troubles with project configuration. If you're not experienced enough to resolve class path errors in projects you're likely to get stuck later on. Stop now :)

Setup
-----

There are 6 eclipse projects included.

aboid - The Game API
aboid-applet - An implementation for applets in Java2D
aboid-android - An implementation for android using the Canvas API
aboid-iphone - An implementation for iphone making use of XMLVM
objc-compat - An update version of the XMLVM compatibility library (note that this is actually included in xmlvm.jar)
TestGame - a simple test game to show the system

Import these projects, they have interdependencies. Note that the aboid-iphone project must export the objc-compat project and that the aboid-android project must export it's android.jar library so that the game can rely on their classes.

Building Applet
---------------

An included ant script build's a versioned applet JAR. Note that the ant script must be configured with the location of your workspace (and hence all the project) and the location of the xmlvm.jar.

The "build" target creates the applet JAR

Building Android
----------------

I use the Android Eclipse integration to build the Android project and test on the emulator. Note that you must generate the R.class file locally to the TestGameActivity class included in the TestGame project.

Building IPhone
---------------

An included ant script build's the ObjC. Note that the ant script must be configured with the location of your workspace (and hence all the project) and the location of the xmlvm.jar.

The "iphone" target generates the ObjC code to the "target/iphone/output" directory. On OSX run "make" in the directory containing the generated ObjC to build the IPhone application (assuming you have the IPhone SDK installed). The make file also tries to run the emulator. You need to run the produced object from the command line to get stdout, rather than through the emulator.

Contact
-------

Please don't contact me with problems, it's not ready yet. For anything else:

kevin@cokeandcode.com
