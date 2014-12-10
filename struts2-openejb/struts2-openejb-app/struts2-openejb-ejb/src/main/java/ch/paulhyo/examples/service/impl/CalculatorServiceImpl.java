package ch.paulhyo.examples.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import ch.paulhyo.examples.service.CalculatorService;

@Stateless  
@Local(CalculatorService.class)  
public class CalculatorServiceImpl implements CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int remainder(int a, int b) {
        return a % b;
    }
}
