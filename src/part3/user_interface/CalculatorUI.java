package part3.user_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import part3.code.Calculator;

public class CalculatorUI {
	
	private Calculator _calc;
	private JTextField _display;
	private JButton _divideKey;
	private JButton _multiplyKey;
	private JButton _subtractKey;
	private JButton _addKey;
	
	public CalculatorUI(Void v) {}

	public CalculatorUI() {
		_calc = new Calculator(this);
		JFrame window = new JFrame("Lab 7");
		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
		window.add(topPanel);

		JPanel buttons = new JPanel();
		window.add(buttons);

		buttons.setLayout(new GridLayout(4, 4));

		_display = new JTextField(8);
		_display.setEditable(false);
		_display.setBackground(Color.BLACK);
		_display.setForeground(Color.RED);
		_display.setFont(new Font("Helvetica Neue", Font.BOLD, 36));
		topPanel.add(_display);
		
		// FIRST ROW
		
		createDigitButton(7,buttons);
		createDigitButton(8,buttons);
		createDigitButton(9,buttons);

		_divideKey = new JButton("<html>&divide;</html>");
		_divideKey.addActionListener(new DivideKeyListener(_calc, this));
		buttons.add(_divideKey);

		// SECOND ROW
		
		createDigitButton(4,buttons);
		createDigitButton(5,buttons);
		createDigitButton(6,buttons);

		_multiplyKey = new JButton("<html>&times;</html>");
		_multiplyKey.addActionListener(new MultiplyKeyListener(_calc, this));
		buttons.add(_multiplyKey);

		// THIRD ROW

		createDigitButton(1,buttons);
		createDigitButton(2,buttons);
		createDigitButton(3,buttons);

		_subtractKey = new JButton("<html>&minus;</html>");
		_subtractKey.addActionListener(new SubtractKeyListener(_calc, this));
		buttons.add(_subtractKey);

		// FOURTH ROW

		JButton clearKey;
		clearKey = new JButton("clear");
		clearKey.setToolTipText("Clear the calculator - reset its value to zero");
		clearKey.addActionListener(new ClearKeyListener(_calc, this));
		buttons.add(clearKey);

		createDigitButton(0,buttons);
		
		JButton equalsKey;
		equalsKey = new JButton("=");
		equalsKey.setToolTipText("Perform computation");
		equalsKey.addActionListener(new EqualKeyListener(_calc, this));
		buttons.add(equalsKey);

		
		_addKey = new JButton("+");
		_addKey.addActionListener(new AddKeyListener(_calc, this));
		buttons.add(_addKey);

		// GENERAL JFrame SET-UP
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		_calc.clearKeyPressed();  // make sure calculator displays zero
	}
	
	private void createDigitButton(int digit, JPanel panel) {
		JButton digitKeyButton;
		digitKeyButton = new JButton(""+digit);
		digitKeyButton.addActionListener(new DigitKeyListener(digit, _calc));
		panel.add(digitKeyButton);
	}

	public void disableOperationKeys() {
		_divideKey.setEnabled(false);
		_multiplyKey.setEnabled(false);
		_subtractKey.setEnabled(false);
		_addKey.setEnabled(false);
	}

	public void enableOperationKeys() {
		_divideKey.setEnabled(true);
		_multiplyKey.setEnabled(true);
		_subtractKey.setEnabled(true);
		_addKey.setEnabled(true);
	}

	public void updateDisplay() {
		_display.setText(""+_calc.getValue());
	}
	
}
