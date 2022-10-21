package org.itmo.calculator.operations;

public class OperationEmpoweredSubtraction implements Operation
{
	@Override
	public String proceed(long operand1, long operand2)
	{
		return String.valueOf((operand1 - operand2) - operand2);
	}
}
