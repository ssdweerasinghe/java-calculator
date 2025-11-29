# Java iOS-Style Calculator

A professional iOS-inspired calculator application built with Java Swing.

## Features

✨ **iOS Design**
- Modern dark theme matching iOS Calculator
- Rounded button corners with smooth interactions
- Clean typography with Helvetica Neue font
- Proper iOS color scheme (dark background, orange operation buttons)

🧮 **Calculator Functions**
- Basic arithmetic operations: addition, subtraction, multiplication, division
- Percentage calculations
- Sign toggle (+/-)
- Decimal point support
- Clear (AC) functionality
- Proper operator chaining

🎨 **UI Features**
- Large, easy-to-read display
- Responsive button grid layout
- Hover effects on buttons
- Hand cursor for interactive elements
- Anti-aliased graphics for smooth rendering

## Project Structure

```
java-calculator/
├── src/
│   └── calculator/
│       ├── Main.java                 # Application entry point
│       ├── iOSCalculatorGUI.java     # GUI implementation
│       └── CalculatorEngine.java     # Calculator logic
├── README.md
└── .git/
```

## Building and Running

### Compile
```powershell
javac -d bin src/calculator/*.java
```

### Run
```powershell
java -cp bin calculator.Main
```

### Or compile and run in one step (Windows PowerShell)
```powershell
javac src/calculator/*.java -d bin; java -cp bin calculator.Main
```

## Usage

1. Click number buttons to enter values
2. Click operation buttons (+, -, ×, ÷) to select an operation
3. Press = to calculate the result
4. Use AC to clear the display
5. Use +/- to toggle the sign
6. Use % to convert to percentage
7. Use . for decimal values

## Technical Details

- **Language**: Java
- **GUI Framework**: Swing
- **Font**: Helvetica Neue (with fallback to default)
- **Color Scheme**: iOS Calculator inspired
  - Dark background: #000000
  - Dark buttons: #333333
  - Light gray buttons: #A5A5A5
  - Orange accent buttons: #FF9F40

## Keyboard Support (Optional Enhancement)

The current implementation supports mouse clicks. Keyboard support can be added by implementing KeyListener in the main frame.

## License

MIT License - Feel free to use and modify this project.

## Author

Created as a demonstration of iOS-style GUI design in Java using Swing.
