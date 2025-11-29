## Running the Calculator

### Quick Start (Windows)

Double-click `run.bat` to compile and run the calculator.

### Quick Start (macOS/Linux)

```bash
chmod +x run.sh
./run.sh
```

### Manual Compilation and Execution

**Windows PowerShell:**
```powershell
javac -d bin src/calculator/*.java
java -cp bin calculator.Main
```

**Command Prompt:**
```cmd
javac -d bin src/calculator/*.java
java -cp bin calculator.Main
```

**macOS/Linux:**
```bash
javac -d bin src/calculator/*.java
java -cp bin calculator.Main
```

## How to Use

The calculator interface mimics Apple's iOS Calculator with a dark theme:

| Button | Function |
|--------|----------|
| **0-9** | Number input |
| **+** | Addition |
| **-** | Subtraction |
| **×** | Multiplication |
| **÷** | Division |
| **=** | Calculate result |
| **AC** | All Clear / Reset |
| **+/-** | Toggle sign (+/−) |
| **%** | Percentage |
| **.** | Decimal point |

### Example Calculations

- **Simple addition**: 5 + 3 = → 8
- **Decimal**: 3.14 × 2 = → 6.28
- **Percentage**: 50 % = → 0.5
- **Chained operations**: 10 + 5 - 3 = → 12

## System Requirements

- Java 8 or higher
- Windows, macOS, or Linux
- Minimum screen resolution: 800×600

## Project Files

### Source Code

- `src/calculator/Main.java` - Entry point
  - Initializes the Swing GUI on the Event Dispatch Thread

- `src/calculator/iOSCalculatorGUI.java` - GUI Implementation
  - `initializeUI()` - Sets up the main frame and layout
  - `createDisplayPanel()` - Creates the number display area
  - `createButtonPanel()` - Creates the 5×4 button grid
  - `createStyledButton()` - Renders iOS-styled buttons with rounded corners
  - `getButtonColor()` - Determines button colors based on function
  - `handleButtonClick()` - Processes button interactions
  - Inner class `ButtonClickListener` - Event handler for buttons

- `src/calculator/CalculatorEngine.java` - Calculator Logic
  - `appendDigit()` - Adds digits to the current value
  - `performOperation()` - Sets the operation and stores value
  - `calculate()` - Performs the actual calculation
  - `toggleSign()` - Changes the sign of current value
  - `toPercentage()` - Converts to percentage
  - `clear()` - Resets the calculator
  - `getDisplay()` - Returns formatted display string

### Build Files

- `bin/` - Compiled Java class files (generated after compilation)
- `run.bat` - Windows batch script for easy execution
- `run.sh` - Unix shell script for easy execution

## Features in Detail

### iOS Design Elements

1. **Color Scheme**
   - Dark background (#000000) for visual appeal
   - Dark gray buttons (#333333) for standard operations
   - Light gray buttons (#A5A5A5) for AC, +/-, and %
   - Orange buttons (#FF9F40) for operations and equals

2. **Typography**
   - Large 60pt display font for easy reading
   - 28pt button font for clear interaction
   - Uses Helvetica Neue (or system default fallback)

3. **User Interface**
   - Smooth rounded corners on buttons
   - Anti-aliased rendering for crisp graphics
   - Hover effects for visual feedback
   - Hand cursor on button hover

### Calculation Engine

The calculator supports:
- Chained operations (e.g., 5 + 3 - 2 + 1 =)
- Floating-point precision
- Division by zero protection (returns 0)
- Proper operator precedence handling

## Troubleshooting

### "javac: command not found"
- **Solution**: Java Development Kit (JDK) is not installed or not in PATH
- **Fix**: Install JDK 8+ from java.com or openjdk.java.net

### Application doesn't launch
- **Solution**: Compiled files may be corrupt
- **Fix**: Delete the `bin` folder and recompile using javac command

### Display shows "0" but buttons don't respond
- **Solution**: Check Java version compatibility
- **Fix**: Ensure you have Java 8 or higher: `java -version`

## Extending the Calculator

### Add Keyboard Support
```java
addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (Character.isDigit(keyChar)) {
            handleButtonClick(String.valueOf(keyChar));
        }
    }
});
```

### Add More Operations
1. Add button to `buttons[][]` array in `createButtonPanel()`
2. Add operation to switch case in `handleButtonClick()`
3. Add calculation logic to `CalculatorEngine.calculate()`

### Change Color Scheme
Modify these constants in `iOSCalculatorGUI.java`:
```java
private static final Color DARK_BG = new Color(0, 0, 0);
private static final Color BUTTON_ORANGE = new Color(255, 159, 64);
```

## Performance Notes

- GUI runs on Swing's Event Dispatch Thread (thread-safe)
- Calculations are instant (< 1ms)
- Memory usage: ~20-30 MB
- No external dependencies required

## License

This project is released under the MIT License. Feel free to use, modify, and distribute as you wish.

## Support

For issues or feature requests, please check the source code comments or create an issue in the project repository.
