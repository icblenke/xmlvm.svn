var/iphone/Makefile:

Updated to include the "assets" directory from the project in the final application bundle. This
is so other resources (outside of PNG) can be bundled in a custom structure.

src/xmlvm/org/xmlvm/Main.java

Updated to cope with array types. Previously when using arrays the generated code included
reference to import nonexistant classes of the form "[[I" etc. Simple hack to just ignore these
types.