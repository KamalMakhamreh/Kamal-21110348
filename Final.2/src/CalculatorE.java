import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalculatorE extends JFrame implements ActionListener {
    private JTextField inputField1, inputField2, inputField3, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modButton;

    public CalculatorE() {
        setLayout(new FlowLayout());
        inputField1 = new JTextField(10);
        add(inputField1);
        
        inputField2 = new JTextField(10);
        add(inputField2);
        
        inputField3 = new JTextField("=");
        inputField3.setEditable(false);
        add(inputField3);
        
        resultField = new JTextField(10);
        resultField.setEditable(false);
        add(resultField);

        addButton = new JButton("+");
        add(addButton);
        addButton.addActionListener(this);

        subtractButton = new JButton("-");
        add(subtractButton);
        subtractButton.addActionListener(this);

        multiplyButton = new JButton("*");
        add(multiplyButton);
        multiplyButton.addActionListener(this);

        divideButton = new JButton("/");
        add(divideButton);
        divideButton.addActionListener(this);
         
        modButton = new JButton("%");
        add(modButton);
        modButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        double num1 = Double.parseDouble(inputField1.getText());
        double num2 = Double.parseDouble(inputField2.getText());
        double result = 0;

        if (event.getSource() == addButton) {
            result = num1 + num2;
        }
        else if (event.getSource() == subtractButton) {
            result = num1 - num2;
        }
        else if (event.getSource() == multiplyButton) {
            result = num1 * num2;
        }
        else if (event.getSource() == divideButton) {
            result = num1 / num2;
        }
        else if (event.getSource() == modButton) {
            result = num1 / num2;
        }
        resultField.setText(" " + result);
    }

    public static void main(String[] args) {
        CalculatorE calculator = new CalculatorE();
        calculator.setTitle("Calculator");
        calculator.setSize(250, 100);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
}
