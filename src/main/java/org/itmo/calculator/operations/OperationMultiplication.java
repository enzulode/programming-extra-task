package org.itmo.calculator.operations;

public class OperationMultiplication implements Operation
{
	@Override
	public String proceed(long operand1, long operand2)
	{
		return String.valueOf(operand1 * operand2);
	}
}
