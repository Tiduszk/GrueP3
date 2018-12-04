@echo off
set /p JDKPath=Enter your Java JDK bin path: 
set /p InstallDIR=Enter the installation directory: 

mkdir %InstallDIR%\GrueP3
mkdir %InstallDIR%\GrueP3\temp
mkdir %InstallDIR%\GrueP3\temp\engine
mkdir %InstallDIR%\GrueP3\temp\parserXML
mkdir %InstallDIR%\GrueP3\temp\script

xcopy engine %InstallDIR%\GrueP3\temp\engine
xcopy parserXML %InstallDIR%\GrueP3\temp\parserXML
xcopy script %InstallDIR%\GrueP3\temp\script
xcopy manifest.txt %InstallDIR%\GrueP3\temp
xcopy person.js %InstallDIR%\GrueP3
xcopy room.js %InstallDIR%\GrueP3
xcopy textGame.xml %InstallDIR%\GrueP3

cd %InstallDIR%/GrueP3/temp
path %JDKPath%;%path%
javac engine/*.java parserXML/*.java script/*.java
jar -cvfm GrueP3.jar manifest.txt engine/*.class parserXML/*.class script/*.class

xcopy GrueP3.jar %InstallDIR%\GrueP3
cd %InstallDIR%\GrueP3
rd %InstallDIR%\GrueP3\temp /s /q

echo. java -jar GrueP3.jar > GrueP3.bat
echo Set oWS = WScript.CreateObject("WScript.Shell") >> %SCRIPT%
echo sLinkFile = "%USERPROFILE%\Desktop\GrueP3.lnk" >> %SCRIPT%
echo Set oLink = oWS.CreateShortcut(sLinkFile) >> %SCRIPT%
echo oLink.TargetPath = "%InstallDIR%\GrueP3\Run.bat" >> %SCRIPT%
echo oLink.Save >> %SCRIPT%
cscript /nologo %SCRIPT%
del %SCRIPT%
pause