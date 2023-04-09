package org.example;

public class CalculatorFactory implements ICalculatorFactory{

    Calculator calculator;
    @Override
    public Calculable create(double real, double imag) {
        this.calculator = new Calculator(real, imag);
        return this.calculator;
    }
}
