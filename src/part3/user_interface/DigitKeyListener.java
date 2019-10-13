package part3.user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import part3.code.Calculator;

public class DigitKeyListener implements ActionListener {
	
	private int _digit;
	private Calculator _calc;
	
	public DigitKeyListener(int d, Calculator c) {
		_digit = d;
		_calc = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_calc.digitKeyPressed(_digit);
	}
}
