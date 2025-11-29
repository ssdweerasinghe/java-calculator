#!/bin/bash
# iOS Calculator - Shell Script
# This script runs the iOS-style calculator application

cd "$(dirname "$0")"

# Check if bin directory exists, if not compile
if [ ! -f "bin/calculator/Main.class" ]; then
    echo "Compiling Java source files..."
    javac -d bin src/calculator/*.java
    if [ $? -ne 0 ]; then
        echo "Compilation failed!"
        exit 1
    fi
    echo "Compilation successful!"
fi

# Run the application
echo "Starting iOS Calculator..."
java -cp bin calculator.Main
