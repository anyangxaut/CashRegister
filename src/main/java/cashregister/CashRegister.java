package cashregister;

import calculator.CalculatorWithBuyTwoGetOneProduct;
import calculator.CalculatorWithDiscountProduct;
import calculator.CalculatorWithOriginalPriceProduct;
import discount.DefaultDiscount;
import discount.DiscountStrategy;
import model.Product;
import printer.ReceiptPrinter;
import utils.FileUtils;

import java.util.HashMap;

public class CashRegister {

    public static final String PROJECTPATH = System.getProperty("user.dir");

    private DiscountStrategy discount = new DefaultDiscount();
    private ReceiptPrinter receiptPrinter = new ReceiptPrinter();

    private HashMap<String, Integer> shoppingCartProductListWithNumber;
    private HashMap<String, Product> supermarketProductList;
    private HashMap<String, String> discountProductListWithDiscount;

    private HashMap<Product, Integer> buyTwoGetOneProductListWithNumber = new HashMap<Product, Integer>();
    private HashMap<Product, Integer> originalPriceProductListWithNumber = new HashMap<Product, Integer>();
    private HashMap<Product, Integer> discountProductListWithNumber = new HashMap<Product, Integer>();

    public CashRegister() {
        shoppingCartProductListWithNumber = this.getShoppingCartProduct(PROJECTPATH
                + "\\data\\shoppingCart.txt");
        supermarketProductList = Supermarket.getInstance().supermarketProducts;
        discountProductListWithDiscount = discount.getDiscount();
        isDiscountProduct();
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }

    private HashMap<String, Integer> getShoppingCartProduct(String filePath) {
        return FileUtils.fileParse(filePath, "shoppingCart");
    }

    private void isDiscountProduct() {
        for (String shoppingCartProductItem : shoppingCartProductListWithNumber.keySet()) {
            if (discountProductListWithDiscount.containsKey(shoppingCartProductItem)) {
                classifyDiscountProduct(shoppingCartProductItem);
            }else {
                originalPriceProductListWithNumber.put(getProductByBarcode(shoppingCartProductItem),
                        shoppingCartProductListWithNumber.get(shoppingCartProductItem));
            }
        }
    }

    private void classifyDiscountProduct(String barcode) {
        String discount = discountProductListWithDiscount.get(barcode);
        if (discount.equals("95")) {
            discountProductListWithNumber.put(getProductByBarcode(barcode),
                    shoppingCartProductListWithNumber.get(barcode));
        }else if (discount.equals("2/1")) {
            buyTwoGetOneProductListWithNumber.put(getProductByBarcode(barcode),
                    shoppingCartProductListWithNumber.get(barcode));
        }
    }

    private Product getProductByBarcode(String barcode) {
        return supermarketProductList.get(barcode);
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        totalPrice = new CalculatorWithOriginalPriceProduct().calculate(originalPriceProductListWithNumber)
                + new CalculatorWithDiscountProduct().calculate(discountProductListWithNumber)
                + new CalculatorWithBuyTwoGetOneProduct().calculate(buyTwoGetOneProductListWithNumber);
        return totalPrice;
    }

    private double calculateTotalSavePrice() {
        double totalSavePrice = 0.0;
        totalSavePrice = calculateSavePriceWithDiscountProducts() + calculateSavePriceWithBuyTwoGetOneProducts();
        return totalSavePrice;
}

    private double calculateSavePriceWithDiscountProducts() {
        double price = 0.0;
        price = new CalculatorWithOriginalPriceProduct().calculate(discountProductListWithNumber)
                - new CalculatorWithDiscountProduct().calculate(discountProductListWithNumber);
        return price;
    }

    private double calculateSavePriceWithBuyTwoGetOneProducts() {
        double price = 0.0;
        price = new CalculatorWithOriginalPriceProduct().calculate(buyTwoGetOneProductListWithNumber)
                - new CalculatorWithBuyTwoGetOneProduct().calculate(buyTwoGetOneProductListWithNumber);
        return price;
    }

    public void printReceipt() {
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append(receiptPrinter.printTitle());
        receiptBuilder.append(receiptPrinter.printMultipleProductWithOriginalPrice(originalPriceProductListWithNumber));
        receiptBuilder.append(receiptPrinter.printMultipleProductWithBuyTwoGetOne(buyTwoGetOneProductListWithNumber));
        receiptBuilder.append(receiptPrinter.printMultipleProductWithDiscount(discountProductListWithNumber));
        receiptBuilder.append(receiptPrinter.printBuyTwoGetOneProduct(buyTwoGetOneProductListWithNumber));
        receiptBuilder.append("******************************\n");
        receiptBuilder.append(receiptPrinter.printSumPrice(this.calculateTotalPrice()));
        receiptBuilder.append(receiptPrinter.printSavePrice(this.calculateTotalSavePrice()));
        receiptBuilder.append("******************************\n");
        System.out.println(receiptBuilder.toString());
    }
}
