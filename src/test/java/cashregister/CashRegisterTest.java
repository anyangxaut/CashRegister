package cashregister;

import calculator.CalculatorWithBuyTwoGetOneProduct;
import calculator.CalculatorWithDiscountProduct;
import calculator.CalculatorWithOriginalPriceProduct;
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
public class CashRegisterTest {

    CashRegister cashRegister;

    @Before
    public void setUp() throws Exception {
        cashRegister = new CashRegister();
    }


}