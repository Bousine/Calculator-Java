package part3.code;

import part3.user_interface.CalculatorUI;
import part3.operations.*;

public class Calculator {

	// The current value of the calculator
	private int _value;
	private BinaryOperation _operation;
	private int _remembered;
	
	// The user interface via which a user interacts 
	private CalculatorUI _ui;
		
	/**
	 * The constructor for the Calculator class, which sets up an association
	 * with a CalculatorUI object.
	 * 
	 * The role of the constructor is to ensure that all instance
	 * variables are initialized to a sensible first value.
	 * 
	 * The initial value of the calculator should be zero.
	 * 
	 * @param calculatorUI - the associated user interface object
	 */
	public Calculator(CalculatorUI calculatorUI) {
		_ui = calculatorUI;
		_value = 0;
		_operation = new NullOp();
	}


	/**
	 * This method is called whenever a digit key is pressed in 
	 * the user interface.
	 * 
	 * Each time a digit key is pressed the current value of the
	 * calculator must be adjusted.
	 * 
	 * For example, assume that the calculator has just been turned
	 * on.  Pressing the '3' key should adjust the value to 3.
	 * Pressing the '7' key next should adjust the value to 37.
	 * Pressing the '4' key next should adjust the value to 374.
	 * 
	 * @param d - the value of the digit key pressed
	 */
	public void digitKeyPressed(int d) {
		_value = _value * 10 + d;
		_ui.updateDisplay();
	}

	/**
	 * This method is called when the 'clear' key is pressed.
	 * 
	 * The calculator must be reset to the same state as 
	 * when it is first turned on.
	 */
	public void clearKeyPressed() {
		_value = 0;
		_ui.updateDisplay();
	}

	/**
	 * This method is called when the '+' key is pressed.
	 * 
	 * The calculator must remember its current value, and
	 * record the that Add operation was selected.
	 * 
	 * Pressing digit keys after this point must build a new
	 * value for the calculator.  For example, pressing 'clear',
	 * '3', '4', '+', '5', and '6' (in that order) must result
	 * in 34 as the remembered value and 56 as the current value.
	 */
	public void addKeyPressed() {
		Add add = new Add();
		_operation = add;
		_remembered = _value;
		_ui.updateDisplay();
		_value = 0;
	}

	/**
	 * This method is called when the '-' key is pressed.
	 * It functions similarly to the addKeyPressed method, 
	 * but for subtraction.
	 */
	public void subtractKeyPressed() {
		Subtract sub = new Subtract();
		_operation = sub;
		_remembered = _value;
		_ui.updateDisplay();
		_value = 0;
	}

	/**
	 * This method is called when the '*' key is pressed.
	 * It functions similarly to the addKeyPressed method, 
	 * but for multiplication.
	 */
	public void multiplyKeyPressed() {
		Multiply mul = new Multiply();
		_operation = mul;
		_remembered = _value;
		_ui.updateDisplay();
		_value = 0;
	}

	/**
	 * This method is called when the '/' key is pressed.
	 * It functions similarly to the addKeyPressed method, 
	 * but for multiplication.
	 */
	public void divideKeyPressed() {
		Divide div = new Divide();
		_operation = div;
		_remembered = _value;
		_ui.updateDisplay();
		_value = 0;
	}

	/**
	 * This method is called when the '=' key is pressed.
	 * 
	 * The calculator must perform the remembered operation, set its
	 * current value to the result of applying the operation to the 
	 * remembered and current value, and then forget both its remembered
	 * value and the remembered operation.
	 * 
	 * For example, pressing 'clear', '3', '4', '+', '5', '6' and '='
	 * (in that order) must set 0 as the remembered value and 
	 * 90 as the current value.
	 */
	public void equalKeyPressed() {
		_value = _operation.perform(_remembered, _value);
		_remembered = 0;
		_ui.updateDisplay();
	}

	
	
	/**
	 * This method is called by the user interface (UI) to
	 * retrieve the current value of the calculator.  It is
	 * the value returned by this method that determines what
	 * is shown in the UI's display.
	 */
	public int getValue() {
		return _value;
	}
}
