@echo off
REM iOS Calculator - Windows Batch Script
REM This script runs the iOS-style calculator application

cd /d "%~dp0"

REM Check if bin directory exists, if not compile
if not exist "bin\calculator\Main.class" (
    echo Compiling Java source files...
    javac -d bin src/calculator/*.java
    if errorlevel 1 (
        echo Compilation failed!
        pause
        exit /b 1
    )
    echo Compilation successful!
)

REM Run the application
echo Starting iOS Calculator...
java -cp bin calculator.Main

pause
