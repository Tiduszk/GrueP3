# GrueP3
Text Adventure Game Engine for CS 370 at SUNY Polytechnic Institute

Created by Zachary Clark and Cody Susta


Java Runtime Environment 7 or above needs to be installed for the following installations to work.


ubuntu installation:

	After cloning repo or extrating to desired location, run following commands,
	chmod 755 ubuntu_install.sh, and then ./ubuntu_install.sh.

	To run the main program, just simply type ./linux_run from terminal in location in the where
	it was cloned or extracted.

Windows installation:

	After cloning repo or extrating to desired location, run following commands,
	Set your JDK path using:
	path [JDKPath/bin];%path%
	Then compile the java files to class files using:
	javac engine/*.java parserXML/*.java script/*.java
	Then add the class files to a jar with:
	jar -cvfm GrueP3.jar manifest.txt engine/*.class parserXML/*.class script/*.class
	
	To run the main program, just simply type java -jar GrueP3.jar from CMD or PowerShell in the location where
	it was cloned or extracted.

	or

	Simply run Install-Windows.bat from the cloned repo, provide it with your Java JDK path and installation directory
	Then run GrueP3.bat from the install directory to start the main program

The included javascript files can be used as templates to create characters and new world locations. If you open the files in a text editor I have indicated what code needs to remain and what code can be changed to add different objects. 

The included XML file can be used as a template for world creation. The user/author is encourage to run the program using it and see how to move around and interact with the world. After getting a sense for it, have fun and create! 

For the main program to be able to locate script files and xml files, they have to be LOCATED IN THE SAME DIRECTORY!!!!!!!!!!!!!!!!!!!!

For anyone comfortable with programming feel free to make any changes you would like and upload them to Github.
In fact it will be frowned upon if you don't!

