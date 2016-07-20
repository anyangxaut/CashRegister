package calculator;

import model.Product;

import java.util.HashMap;

public interface CalculatorStrategy {

    public double calculate(HashMap<Product, Integer> ProductListWithNumber);
}
