package part3.operations;

public class Add implements BinaryOperation {
	public Add() {}
	
	@Override
	public int perform(int left, int right) {
		return left + right;
	}
}
