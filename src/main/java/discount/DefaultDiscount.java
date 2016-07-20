package discount;

import cashregister.CashRegister;
import utils.FileUtils;

import java.util.HashMap;

public class DefaultDiscount implements DiscountStrategy {

    public static final double DISCOUNT = 0.95;

    public HashMap<String, String> getDiscount() {
        return FileUtils.fileParse(CashRegister.PROJECTPATH + "\\data\\discount.txt", "discount");
    }
}
