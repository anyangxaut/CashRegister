package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Product product;

    @Before
    public void setUp() throws Exception {
        String barcode = "ITEM000000";
        String name = "可口可乐";
        String unit = "瓶";
        String category = "食品";
        String subCategory = "碳酸饮料";
        double price = 3.00;

        product = new Product(barcode,name, unit, category, subCategory, price);
    }

    @Test
    public void testGetBarcode() throws Exception {
        String expectedStr = "ITEM000000";

        String barcode = product.getBarcode();

        assertEquals(expectedStr, barcode);
    }

    @Test
    public void testGetName() throws Exception {
        String expectedStr = "可口可乐";

        String name = product.getName();

        assertEquals(expectedStr, name);
    }

    @Test
    public void testGetUnit() throws Exception {
        String expectedStr = "瓶";

        String unit = product.getUnit();

        assertEquals(expectedStr, unit);
    }

    @Test
    public void testGetCategory() throws Exception {
        String expectedStr = "食品";

        String category = product.getCategory();

        assertEquals(expectedStr, category);
    }

    @Test
    public void testGetSubCategory() throws Exception {
        String expectedStr = "碳酸饮料";

        String subcategory = product.getSubCategory();

        assertEquals(expectedStr, subcategory);
    }

    @Test
    public void testGetPrice() throws Exception {
        double expectedPrice = 3.00;

        double price = product.getPrice();

        assertEquals(expectedPrice, price, 0.01);
    }

    @Test
    public void testToString() throws Exception {
        String expectedStr = "barcode:ITEM000000, name:可口可乐, unit:瓶, category:食品, subCategory:碳酸饮料, price:3.0";

        String result = product.toString();

        assertEquals(expectedStr, result);
    }
}
