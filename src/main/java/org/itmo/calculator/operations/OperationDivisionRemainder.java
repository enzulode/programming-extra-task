package org.itmo.calculator.operations;

public class OperationDivisionRemainder implements Operation
{
	@Override
	public String proceed(long operand1, long operand2)
	{
		if (operand2 == 0)
			return "ERROR_0";

		if (operand2 < 0)
			return "ERROR_3";

		return String.valueOf(operand1 % operand2);
	}
}
