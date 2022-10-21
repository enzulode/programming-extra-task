package org.itmo.calculator.util;

import org.itmo.calculator.operations.Operation;

public class SuperMap
{
	private int lastIndex = 0;
	private Pair[] array;
	public SuperMap()
	{
		array = new Pair[10];
	}

	public Operation get(String symbol)
	{

		for (int i = 0; i <= lastIndex; i++)
			if (array[i].symbol.equals(symbol))
				return array[i].obj;

		return null;
	}

	public void put(String symbol, Operation obj)
	{
		array[lastIndex] = new Pair(symbol, obj);
		lastIndex++;
	}



}
