#!/bin/bash

javac engine/*.java parserXML/*.java script/*.java
jar -cvfm grue.jar manifest.txt engine/*.class parserXML/*.class script/*.class
chmod 755 linux_run

