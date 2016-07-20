package calculator;

import model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by anyang on 2016/7/20.
 */
public class CalculatorWithBuyTwoGetOneProductTest {

    CalculatorWithBuyTwoGetOneProduct calculatorWithBuyTwoGetOneProduct;

    @Before
    public void setUp() throws Exception {
       calculatorWithBuyTwoGetOneProduct = new CalculatorWithBuyTwoGetOneProduct();
    }

    @Test
    public void testCalculatePriceWithSingleProduct() throws Exception {
        HashMap<Product, Integer> buyTwoGetOneProductListWithNumber = new HashMap<Product, Integer>();
        buyTwoGetOneProductListWithNumber.put(createProduct(2.0), 1);

        double price = calculatorWithBuyTwoGetOneProduct.calculate(buyTwoGetOneProductListWithNumber);

        assertEquals(2.0, price, 0.01);
    }

    @Test
    public void testCalculatePriceWithMultipleProduct() throws Exception {
        HashMap<Product, Integer> buyTwoGetOneProductListWithNumber = new HashMap<Product, Integer>();
        buyTwoGetOneProductListWithNumber.put(createProduct(2.0), 1);
        buyTwoGetOneProductListWithNumber.put(createProduct(3.0), 2);
        buyTwoGetOneProductListWithNumber.put(createProduct(4.0), 3);
        buyTwoGetOneProductListWithNumber.put(createProduct(2.0), 4);

        double price = calculatorWithBuyTwoGetOneProduct.calculate(buyTwoGetOneProductListWithNumber);

        assertEquals(22.0, price, 0.01);
    }

    @Test
    public void testCalculatePriceWithProductNumberIsThreeMultiple() throws Exception {
        HashMap<Product, Integer> buyTwoGetOneProductListWithNumber = new HashMap<Product, Integer>();
        buyTwoGetOneProductListWithNumber.put(createProduct(2.0), 1);
        buyTwoGetOneProductListWithNumber.put(createProduct(3.0), 2);
        buyTwoGetOneProductListWithNumber.put(createProduct(4.0), 3);

        double price = calculatorWithBuyTwoGetOneProduct.calculate(buyTwoGetOneProductListWithNumber);

        assertEquals(16.0, price, 0.01);
    }

    @Test
    public void testCalculatePriceWithProductNumberIsNotThreeMultiple() throws Exception {
        HashMap<Product, Integer> buyTwoGetOneProductListWithNumber = new HashMap<Product, Integer>();
        buyTwoGetOneProductListWithNumber.put(createProduct(2.0), 1);
        buyTwoGetOneProductListWithNumber.put(createProduct(3.0), 2);

        double price = calculatorWithBuyTwoGetOneProduct.calculate(buyTwoGetOneProductListWithNumber);

        assertEquals(8.0, price, 0.01);
    }

    private Product createProduct(double price) {
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(price);
        return product;
    }
}