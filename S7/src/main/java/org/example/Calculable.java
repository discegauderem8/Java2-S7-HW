package org.example;

public interface Calculable {
    public Calculable plus (Calculator b);

    public Calculable mult(Calculator b);

    public Calculable divide(Calculator b);

    public Calculable reciprocal();

    public Calculable sub(Calculator b);

}
