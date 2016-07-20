package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carrie on 2016/7/20.
 */
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
        //ITEM000000,可口可乐,瓶,食品,碳酸饮料,3.00
        product = new Product(barcode,name, unit, category, subCategory, price);
    }

    @Test
    public void testGetBarcode() throws Exception {
        String barcode = product.getBarcode();

        assertEquals("ITEM000000", barcode);
    }

    @Test
    public void testGetName() throws Exception {
        String name = product.getName();

        assertEquals("可口可乐", name);
    }

    @Test
    public void testGetUnit() throws Exception {
        String unit = product.getUnit();

        assertEquals("瓶", unit);
    }

    @Test
    public void testGetCategory() throws Exception {
        String category = product.getCategory();

        assertEquals("食品", category);
    }

    @Test
    public void testGetSubCategory() throws Exception {
        String subcategory = product.getSubCategory();

        assertEquals("碳酸饮料", subcategory);
    }

    @Test
    public void testGetPrice() throws Exception {
        double price = product.getPrice();

        assertEquals(3.00, price, 0.01);
    }

    @Test
    public void testToString() throws Exception {
        String result = product.toString();

        assertEquals("barcode=ITEM000000, name=可口可乐, unit=瓶, category=食品, subCategory=碳酸饮料, price=3.0", result);
    }
}
