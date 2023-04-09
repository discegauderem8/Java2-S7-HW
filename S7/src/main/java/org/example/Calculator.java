package org.example;

import java.util.concurrent.Callable;

public class Calculator implements Calculable { // Смотри записи в конспектах и закладки в браузере для подробностей
    private final double re;
    private final double im;

    public Calculator(double real, double imag) {
        re = real;
        im = imag;
    }

    public Calculator plus(Calculator b) {
        Calculator a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Calculator(real, imag);
    }


    public Calculator mult(Calculator b) {
        Calculator a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Calculator(real, imag);
    }



    public Calculator divide(Calculator b) {
        Calculator a = this;
        return a.mult(b.reciprocal());
    }

    public Calculator reciprocal() {
        double scale = re * re + im * im;
        return new Calculator(re / scale, -im / scale); //Вот эту формулу подсмотрел, честно говоря
    }

    @Override
    public Calculator sub(Calculator b) {
        Calculator a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Calculator(real, imag);
    }

    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im < 0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

}

