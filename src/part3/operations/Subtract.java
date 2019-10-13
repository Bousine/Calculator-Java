package part3.operations;


public class Subtract implements BinaryOperation {
	public Subtract() {}
	
	@Override
	public int perform(int left, int right) {
		return left - right;
	}

}