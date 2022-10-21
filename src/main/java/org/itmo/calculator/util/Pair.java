package org.itmo.calculator.util;

import org.itmo.calculator.operations.Operation;

public class Pair
{
	public String symbol;
	public Operation obj;

	public Pair(String smbl, Operation oper)
	{
		symbol = smbl;
		obj = oper;
	}
}
