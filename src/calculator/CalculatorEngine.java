package calculator;

/**
 * Core calculator engine that handles mathematical operations
 */
public class CalculatorEngine {
    private double currentValue;
    private double storedValue;
    private String operation;
    private boolean shouldClearDisplay;

    public CalculatorEngine() {
        this.currentValue = 0;
        this.storedValue = 0;
        this.operation = null;
        this.shouldClearDisplay = true;
    }

    /**
     * Append a digit to the current value
     */
    public void appendDigit(String digit) {
        if (shouldClearDisplay) {
            currentValue = Double.parseDouble(digit);
            shouldClearDisplay = false;
        } else {
            String currentStr = formatNumber(currentValue);
            if (!currentStr.contains(".") || !digit.equals(".")) {
                currentStr += digit;
                currentValue = Double.parseDouble(currentStr);
            }
        }
    }

    /**
     * Perform a mathematical operation
     */
    public void performOperation(String op) {
        if (operation != null && !shouldClearDisplay) {
            calculate();
        } else {
            storedValue = currentValue;
        }
        operation = op;
        shouldClearDisplay = true;
    }

    /**
     * Calculate the result of the pending operation
     */
    public void calculate() {
        if (operation == null) {
            return;
        }

        switch (operation) {
            case "+":
                currentValue = storedValue + currentValue;
                break;
            case "-":
                currentValue = storedValue - currentValue;
                break;
            case "*":
                currentValue = storedValue * currentValue;
                break;
            case "/":
                if (currentValue != 0) {
                    currentValue = storedValue / currentValue;
                } else {
                    currentValue = 0;
                }
                break;
            case "%":
                currentValue = storedValue % currentValue;
                break;
        }

        operation = null;
        shouldClearDisplay = true;
    }

    /**
     * Toggle the sign of the current value
     */
    public void toggleSign() {
        currentValue = -currentValue;
    }

    /**
     * Convert the current value to percentage
     */
    public void toPercentage() {
        currentValue = currentValue / 100;
    }

    /**
     * Clear the calculator
     */
    public void clear() {
        currentValue = 0;
        storedValue = 0;
        operation = null;
        shouldClearDisplay = true;
    }

    /**
     * Get the current display value
     */
    public String getDisplay() {
        return formatNumber(currentValue);
    }

    /**
     * Format a number for display (remove unnecessary decimals)
     */
    private String formatNumber(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.format("%s", value).replaceAll("0*$", "").replaceAll("\\.$", "");
        }
    }

    /**
     * Get the current value
     */
    public double getCurrentValue() {
        return currentValue;
    }

    /**
     * Set the current value
     */
    public void setCurrentValue(double value) {
        currentValue = value;
        shouldClearDisplay = true;
    }
}
