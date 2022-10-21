package org.itmo.calculator.app;

import org.itmo.calculator.operations.*;
import org.itmo.calculator.util.SuperMap;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorApp
{

	private long operandRight;
	private long operandLeft;
	private long lastResult;
	private String operationProceeded;
	private long[] memory;
	private final SuperMap operationsMap = new SuperMap();

	public CalculatorApp(int memoryCellsSize)
	{
		fillOperationsMap();
		initMemory(memoryCellsSize);
	}

	public String calculate(String expression)
	{

		String[] operands = expression.split(" ");

		proceedOperation(operands[0], operands[2], operands[1]);

		if (operationErrored())
			return operationProceeded;

		lastResult = Long.parseLong(operationProceeded);

		int i = 3;
		while (i < operands.length)
		{
			proceedOperation(String.valueOf(lastResult), operands[i+1], operands[i]);
			if (operationErrored())
				return operationProceeded;

			lastResult = Long.parseLong(operationProceeded);
			i = i + 2;
		}

		return String.valueOf(lastResult);
	}

	public String resetMemory(int memoryCellIndex)
	{
		if (validateMemoryCellIndex(memoryCellIndex) && memoryCellIndex < memory.length)
		{
			memory[memoryCellIndex] = 0;
			return "0";
		}

		return "ERROR_1";
	}

	public String putLastResultInMemory(int memoryCellIndex)
	{
		if (validateMemoryCellIndex(memoryCellIndex) && memoryCellIndex < memory.length)
		{
			memory[memoryCellIndex] = lastResult;
			return String.valueOf(lastResult);
		}

		return "ERROR_1";
	}

	private void fillOperationsMap()
	{
		operationsMap.put("+", new OperationPlus());
		operationsMap.put("-", new OperationSubtraction());
		operationsMap.put("*", new OperationMultiplication());
		operationsMap.put("/", new OperationDivision());
		operationsMap.put("%", new OperationDivisionRemainder());
		operationsMap.put("^", new OperationExponentiation());
		operationsMap.put("++", new OperationEmpoweredPlus());
		operationsMap.put("--", new OperationEmpoweredSubtraction());
		operationsMap.put("*/", new OperationEmpoweredDivision());
	}

	public void initMemory(int memoryCellSize)
	{
		if (validateMemoryCellIndex(memoryCellSize))
			memory = new long[memoryCellSize];
		else
			memory = new long[0];

		Arrays.fill(memory, 0);
	}

	public boolean validateMemoryCellIndex(int index)
	{
		return (index >= 0) && (index <= 100);
	}

	public String proceedOperation(String operand1, String operand2, String op)
	{
		initOperandsValues(operand1, operand2);
		Operation operation = operationsMap.get(op);

		operationProceeded = operation.proceed(operandLeft, operandRight);
		return operationProceeded;
	}

	private boolean isOperandMemoryCellPointer(String operand)
	{
		Pattern memoryCellPattern = Pattern.compile("M(\\d+)");
		Matcher matcher = memoryCellPattern.matcher(operand);

		return matcher.find();
	}

	private void initOperandsValues(String operand1, String operand2)
	{
		if (isOperandMemoryCellPointer(operand1))
			operandLeft = getMemoryCellValueByPointer(operand1);
		else
			operandLeft = Long.parseLong(operand1);

		if (isOperandMemoryCellPointer(operand2))
			operandRight = getMemoryCellValueByPointer(operand2);
		else
			operandRight = Long.parseLong(operand2);
	}

	private long getMemoryCellValueByPointer(String pointer)
	{
		Pattern memoryCellPattern = Pattern.compile("M(\\d+)");
		Matcher matcher = memoryCellPattern.matcher(pointer);
		matcher.find();
		return memory[Integer.parseInt(matcher.group(1))];
	}

	private boolean operationErrored()
	{
		return operationProceeded.equals("ERROR_0")
						|| operationProceeded.equals("ERROR_1")
						|| operationProceeded.equals("ERROR_2")
						|| operationProceeded.equals("ERROR_3");
	}

}
