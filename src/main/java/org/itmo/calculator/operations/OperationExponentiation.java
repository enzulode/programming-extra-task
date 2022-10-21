package org.itmo.calculator.operations;

public class OperationExponentiation implements Operation
{
	@Override
	public String proceed(long operand1, long operand2)
	{
		if (operand2 < 0)
			return "ERROR_2";

		return String.valueOf((long) Math.pow(operand1, operand2));
	}
}
