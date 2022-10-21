package org.itmo.calculator.operations;

public class OperationEmpoweredDivision implements Operation
{
	@Override
	public String proceed(long operand1, long operand2)
	{
		if (operand2 == 0)
			return "ERROR_0";

		return String.valueOf((operand1 * operand2) / operand2);
	}
}
