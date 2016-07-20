package calculator;

import model.Product;

import java.util.HashMap;

public class CalculatorWithOriginalPriceProduct implements CalculatorStrategy {

    public double calculate(HashMap<Product, Integer> originalPriceProductListWithNumber) {
        double price = 0.0;
        for (Product originalPriceProductItem : originalPriceProductListWithNumber.keySet()) {
            price += originalPriceProductItem.getPrice() * originalPriceProductListWithNumber.get(originalPriceProductItem);
        }
        return price;
    }
}
