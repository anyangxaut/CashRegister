package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by anyang on 2016/7/18.
 */
public class Product {
    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private double price;

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

    public JSONObject toJson(){
        JSONObject object = new JSONObject();
        try {
            object.put("barcode", barcode);
            object.put("name", name);
            object.put("unit", unit);
            object.put("category", category);
            object.put("subCategory", subCategory);
            object.put("price", price);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return object;
    }
}
