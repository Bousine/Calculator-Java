package part3.operations;


public class Multiply implements BinaryOperation {
	public Multiply() {}
	
	@Override
	public int perform(int left, int right) {
		return left * right;
	}

}
