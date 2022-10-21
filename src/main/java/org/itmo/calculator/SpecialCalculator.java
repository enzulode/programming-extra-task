package org.itmo.calculator;

import org.itmo.calculator.app.CalculatorApp;

public final class SpecialCalculator
{

    private CalculatorApp app;
    public SpecialCalculator(int memoryCellsSize)
    {
        app = new CalculatorApp(memoryCellsSize);
    }

    public String calculate(String expression)
    {
        return app.calculate(expression);
    }

    public String putLastResultInMemory(int memoryCellIndex)
    {
        return app.putLastResultInMemory(memoryCellIndex);
    }

    public String resetMemory(int memoryCellIndex)
    {
        return app.resetMemory(memoryCellIndex);
    }
}
