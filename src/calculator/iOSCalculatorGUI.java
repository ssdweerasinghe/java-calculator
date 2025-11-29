package calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

/**
 * iOS-style Calculator GUI using Swing
 */
public class iOSCalculatorGUI extends JFrame {
    private CalculatorEngine engine;
    private JLabel displayLabel;
    private JPanel buttonPanel;

    // iOS Colors
    private static final Color DARK_BG = new Color(0, 0, 0);
    private static final Color BUTTON_DARK = new Color(51, 51, 51);
    private static final Color BUTTON_LIGHT_GRAY = new Color(165, 165, 165);
    private static final Color BUTTON_ORANGE = new Color(255, 159, 64);
    private static final Color DISPLAY_TEXT = new Color(255, 255, 255);
    private static final Font DISPLAY_FONT = new Font("Helvetica Neue", Font.PLAIN, 60);
    private static final Font BUTTON_FONT = new Font("Helvetica Neue", Font.PLAIN, 28);

    public iOSCalculatorGUI() {
        engine = new CalculatorEngine();
        initializeUI();
    }

    private void initializeUI() {
        // Frame setup
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(false);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Add window listener for close button
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(DARK_BG);
        mainPanel.setLayout(new BorderLayout(0, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Display panel
        JPanel displayPanel = createDisplayPanel();
        mainPanel.add(displayPanel, BorderLayout.NORTH);

        // Button grid panel
        buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        setSize(400, 700);
        setLocationRelativeTo(null);
    }

    private JPanel createDisplayPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(DARK_BG);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 10, 20, 10));

        displayLabel = new JLabel("0");
        displayLabel.setFont(DISPLAY_FONT);
        displayLabel.setForeground(DISPLAY_TEXT);
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);

        panel.add(displayLabel, BorderLayout.EAST);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(DARK_BG);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Button layout: same as iOS calculator
        String[][] buttons = {
            {"AC", "+/-", "%", "÷"},
            {"7", "8", "9", "×"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"0", ".", "=", null}
        };

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                String label = buttons[i][j];
                if (label != null) {
                    JButton button = createStyledButton(label);
                    button.addActionListener(new ButtonClickListener(label));
                    panel.add(button);
                } else {
                    panel.add(new JPanel());
                }
            }
        }

        return panel;
    }

    private JButton createStyledButton(String label) {
        JButton button = new JButton(label) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Determine button color
                Color bgColor = getButtonColor(label);
                g2d.setColor(bgColor);

                // Draw rounded rectangle
                RoundRectangle2D rect = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15);
                g2d.fill(rect);

                // Draw button text
                g2d.setColor(label.equals("AC") || label.equals("+/-") || label.equals("%") ? Color.BLACK : DISPLAY_TEXT);
                g2d.setFont(BUTTON_FONT);
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(label)) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g2d.drawString(label, x, y);
            }
        };

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(BUTTON_FONT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setOpaque(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setOpaque(false);
            }
        });

        return button;
    }

    private Color getButtonColor(String label) {
        if (label.equals("AC") || label.equals("+/-") || label.equals("%")) {
            return BUTTON_LIGHT_GRAY;
        } else if (label.equals("+") || label.equals("-") || label.equals("×") || label.equals("÷") || label.equals("=")) {
            return BUTTON_ORANGE;
        } else {
            return BUTTON_DARK;
        }
    }

    private void updateDisplay() {
        displayLabel.setText(engine.getDisplay());
    }

    private class ButtonClickListener implements ActionListener {
        private String buttonLabel;

        public ButtonClickListener(String label) {
            this.buttonLabel = label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            handleButtonClick(buttonLabel);
            updateDisplay();
        }
    }

    private void handleButtonClick(String label) {
        switch (label) {
            case "AC":
                engine.clear();
                break;
            case "+/-":
                engine.toggleSign();
                break;
            case "%":
                engine.toPercentage();
                break;
            case "÷":
                engine.performOperation("/");
                break;
            case "×":
                engine.performOperation("*");
                break;
            case "-":
                engine.performOperation("-");
                break;
            case "+":
                engine.performOperation("+");
                break;
            case "=":
                engine.calculate();
                break;
            case ".":
                engine.appendDigit(".");
                break;
            default:
                // It's a digit
                engine.appendDigit(label);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            iOSCalculatorGUI calculator = new iOSCalculatorGUI();
            calculator.setVisible(true);
        });
    }
}
