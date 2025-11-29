package calculator;

/**
 * Main entry point for the iOS Calculator application
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            iOSCalculatorGUI calculator = new iOSCalculatorGUI();
            calculator.setVisible(true);
        });
    }
}
