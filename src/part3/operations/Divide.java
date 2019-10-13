package part3.operations;


public class Divide implements BinaryOperation {
	public Divide() {}
	
	@Override
	public int perform(int left, int right) {
		return left / right;
	}

}

