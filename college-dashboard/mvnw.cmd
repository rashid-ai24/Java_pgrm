@echo off
rem ---------------------------------------------------------------------------
rem Maven Wrapper (Windows)
rem Resolves project base directory and runs the maven-wrapper JAR with java -jar
rem ---------------------------------------------------------------------------
setlocal
set "MAVEN_PROJECTBASEDIR=%~dp0"
if defined JAVA_HOME (
	set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
) else (
	set "JAVA_EXE=java"
)

"%JAVA_EXE%" -jar "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar" %*
