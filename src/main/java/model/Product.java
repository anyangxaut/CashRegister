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

    @Override
    public String toString() {
<<<<<<< HEAD
        return
                "barcode=" + barcode +
                ", name=" + name +
                ", unit=" + unit +
                ", category=" + category +
                ", subCategory=" + subCategory +
                ", price=" + price;
=======
        return "barcode:" + barcode + ", name:" + name + ", unit" + unit + ", category" + category
                + ", subCategory:" + subCategory + ", price:" + price;
>>>>>>> f5fc2e98582234f445e47c44a8ea2e5244b02c2d
    }
}
