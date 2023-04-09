package org.example;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.logging.*;
import java.util.Scanner;


public class ViewCalculator implements IViewCalculator {

    private CalculatorFactory calculatorFactory;
    private Calculator calculator;
//    public static Logger logger;

    public ViewCalculator(CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
//        logger = Logger.getLogger("myLogger");
//        logger.info("я родился");
//        logger.addHandler(new ConsoleHandler());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(("Введите реальную часть первого комплексного числа: "));
            double real1 = scanner.nextDouble();
            System.out.println(("Введите мнимую часть первого комплексного числа: "));
            double imag1 = scanner.nextDouble();
            calculator = (Calculator) calculatorFactory.create(real1, imag1);
//            logger.log(Level.INFO, "Калькулятор успешно принял первое комплексное число");
            System.out.println("Logger: Калькулятор успешно принял первое комплексное число");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (true) {
                System.out.println("Введите команду (*, +, =) : ");
                String cmd = scanner.next();
                if (cmd.equals("*")) {
                    System.out.println(("Введите реальную часть второго комплексного числа: "));
                    double real2 = scanner.nextDouble();
                    System.out.println(("Введите мнимую часть второго комплексного числа: "));
                    double imag2 = scanner.nextDouble();
                    calculator = calculator.mult((Calculator) calculatorFactory.create(real2, imag2));
//                    logger.log(Level.INFO, "Калькулятор произвел умножение");
                    System.out.println("Logger: Калькулятор успешно произвел умножение");
                } else if (cmd.equals("/")) {
                    System.out.println(("Введите реальную часть второго комплексного числа: "));
                    double real2 = scanner.nextDouble();
                    System.out.println(("Введите мнимую часть второго комплексного числа: "));
                    double imag2 = scanner.nextDouble();
                    calculator = calculator.divide((Calculator) calculatorFactory.create(real2, imag2));
//                    logger.log(Level.INFO, "Калькулятор произвел деление");
                    System.out.println("Logger: Калькулятор успешно произвел деление");
                } else if (cmd.equals("+")) {
                    System.out.println(("Введите реальную часть второго комплексного числа: "));
                    double real2 = scanner.nextDouble();
                    System.out.println(("Введите мнимую часть второго комплексного числа: "));
                    double imag2 = scanner.nextDouble();
                    calculator = calculator.plus((Calculator) calculatorFactory.create(real2, imag2));
//                    logger.log(Level.INFO, "Калькулятор произвел сложение");
                    System.out.println("Logger: Калькулятор успешно произвел сложение");
                } else if (cmd.equals("-")) {
                    System.out.println(("Введите реальную часть второго комплексного числа: "));
                    double real2 = scanner.nextDouble();
                    System.out.println(("Введите мнимую часть второго комплексного числа: "));
                    double imag2 = scanner.nextDouble();
                    calculator = calculator.sub((Calculator) calculatorFactory.create(real2, imag2));
//                    logger.log(Level.INFO, "Калькулятор произвел вычитание");
                    System.out.println("Logger: Калькулятор успешно произвел вычитание");
                } else if (cmd.equals("=")) {
                    String result = calculator.toString();
                    System.out.println("Результат: " + result);
//                    logger.log(Level.INFO, "Калькулятор вывел результат");
                    System.out.println("Хотите посчитать еще раз? (Y - да, любая другая клавиша - нет)");
                    cmd = scanner.next();
                    if (cmd.toLowerCase().equals("n")) {
//                        logger.log(Level.INFO, "Калькулятор завершил работу");
                        System.out.println("Logger: Калькулятор завершил работу");
                        break;
                    }
                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
        }
        try {
        } finally {
            scanner.close();
        }
    }
}
