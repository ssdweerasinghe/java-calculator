@echo off
REM Quick Reference for iOS Calculator
REM ===================================

echo iOS Calculator - Quick Reference
echo ==================================
echo.
echo RUNNING THE APPLICATION:
echo.
echo Method 1 (Windows):
echo   - Double-click run.bat
echo   - Or run: run.bat
echo.
echo Method 2 (macOS/Linux):
echo   - Run: ./run.sh
echo   - Or:  bash run.sh
echo.
echo Method 3 (Manual - All Platforms):
echo   - javac -d bin src/calculator/*.java
echo   - java -cp bin calculator.Main
echo.
echo METHOD 4 (Using Make - macOS/Linux):
echo   - make run       (compile and run)
echo   - make compile   (compile only)
echo   - make clean     (remove compiled files)
echo.
echo SYSTEM REQUIREMENTS:
echo   - Java 8 or higher
echo   - 30 MB RAM minimum
echo   - Windows, macOS, or Linux
echo.
echo DOCUMENTATION:
echo   - README.md          - Main documentation
echo   - USAGE.md           - Detailed usage guide
echo   - PROJECT_SUMMARY.md - Complete project information
echo.
echo SOURCE FILES:
echo   - src/calculator/Main.java              - Entry point
echo   - src/calculator/iOSCalculatorGUI.java  - GUI implementation
echo   - src/calculator/CalculatorEngine.java  - Calculator logic
echo.
echo TROUBLESHOOTING:
echo   - If javac not found: Install Java Development Kit (JDK)
echo   - If app doesn't launch: Delete bin folder and recompile
echo   - Check Java version: java -version (requires Java 8+)
echo.
pause
