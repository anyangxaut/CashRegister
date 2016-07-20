package calculator;

import discount.DefaultDiscount;
import model.Product;

import java.util.HashMap;

public class CalculatorWithDiscountProduct implements CalculatorStrategy {

    public double calculate(HashMap<Product, Integer> discountProductListWithNumber) {
        double price = 0.0;
        for (Product discountProductItem : discountProductListWithNumber.keySet()) {
            price += discountProductItem.getPrice() * discountProductListWithNumber.get(discountProductItem)
                    * DefaultDiscount.DISCOUNT;
        }
        return price;
    }
}
