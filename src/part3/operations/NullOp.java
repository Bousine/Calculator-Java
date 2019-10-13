package part3.operations;

public class NullOp implements BinaryOperation{
	public NullOp() {}
	
	@Override
	public int perform(int left, int right) {
		return right;
	}

}
