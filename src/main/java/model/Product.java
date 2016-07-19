package model;

/**
 * Created by anyang on 2016/7/18.
 */
public class Product {
    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private double price = 0.0;

    public Product(String barcode, String name, String unit, String category, String subCategory, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.subCategory = subCategory;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public double getPrice() {
        return price;
    }
}
