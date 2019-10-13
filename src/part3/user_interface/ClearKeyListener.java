package part3.user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import part3.code.Calculator;

public class ClearKeyListener implements ActionListener {

	private Calculator _calc;
	private CalculatorUI _ui;
	
	public ClearKeyListener(Calculator c, CalculatorUI calculatorUI) {
		_calc = c;
		_ui = calculatorUI;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 _calc.clearKeyPressed();
		 _ui.enableOperationKeys();
	}
}
