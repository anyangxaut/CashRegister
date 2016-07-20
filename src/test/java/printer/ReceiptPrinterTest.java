package printer;

import model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ReceiptPrinterTest {

    ReceiptPrinter receiptPrinter;

    @Before
    public void setUp() throws Exception {
        receiptPrinter = new ReceiptPrinter();
    }

    @Test
    public void testPrintTitle() throws Exception {
        String expectedstr = "***<没钱赚商店>购物清单***\n";

        String title = receiptPrinter.printTitle();

        assertEquals(expectedstr, title);
    }

    @Test
    public void testPrintBuyTwoGetOneProduct() throws Exception {
        HashMap<Product, Integer> buyTwoGetOneProductListWithNumber =  new HashMap<Product, Integer>();
        buyTwoGetOneProductListWithNumber.put(createProduct("可口可乐", "瓶", 3.00 ), 1);
        buyTwoGetOneProductListWithNumber.put(createProduct("面包", "个", 4.50 ), 3);

        String result = receiptPrinter.printBuyTwoGetOneProduct(buyTwoGetOneProductListWithNumber);

        assertEquals("******************************\n买二赠一商品：\n名称：面包，数量：3个\n名称：可口可乐，数量：1瓶\n", result);
    }

    @Test
    public void testPrintMultipleProductWithOriginalPrice() throws Exception {
        HashMap<Product, Integer> originalPriceProductListWithNumber = new HashMap<Product, Integer>();
        originalPriceProductListWithNumber.put(createProduct("可口可乐", "瓶", 3.00 ), 1);
        originalPriceProductListWithNumber.put(createProduct("面包", "个", 4.50 ), 3);

        String result = receiptPrinter.printMultipleProductWithOriginalPrice(originalPriceProductListWithNumber);

        assertEquals("名称：面包，数量：3个，单价：4.50(元)，小计：13.50(元)\n名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n",result);
    }

    @Test
    public void testPrintMultipleProductWithBuyTwoGetOne() throws Exception {
        HashMap<Product, Integer> buyTwoGetOneProductListWithNumber = new HashMap<Product, Integer>();
        buyTwoGetOneProductListWithNumber.put(createProduct("可口可乐", "瓶", 3.00 ), 1);
        buyTwoGetOneProductListWithNumber.put(createProduct("面包", "个", 4.50 ), 3);

        String result = receiptPrinter.printMultipleProductWithBuyTwoGetOne(buyTwoGetOneProductListWithNumber);

        assertEquals("名称：面包，数量：3个，单价：4.50(元)，小计：9.00(元)\n名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n", result);

    }

    @Test
    public void testPrintMultipleProductWithDiscount() throws Exception {
        HashMap<Product, Integer> discountProductListWithNumber = new HashMap<Product, Integer>();
        discountProductListWithNumber.put(createProduct("可口可乐", "瓶", 3.00 ), 4);
        discountProductListWithNumber.put(createProduct("面包", "个", 4.50 ), 3);

        String result = receiptPrinter.printMultipleProductWithDiscount(discountProductListWithNumber);

        assertEquals("名称：面包，数量：3个，单价：4.50(元)，小计：12.83(元), 节省：0.68(元)\n名称：可口可乐，数量：4瓶，单价：3.00(元)，小计：11.40(元), 节省：0.60(元)\n", result);
    }

    @Test
    public void testPrintSavePrice() throws Exception {
        double savePrice = 1.00;

        String result = receiptPrinter.printSavePrice(savePrice);

        assertEquals("节省：1.00(元)\n", result);
    }

    @Test
    public void testPrintSumPrice() throws Exception {
        double sumPrice = 12.34;

        String result = receiptPrinter.printSumPrice(sumPrice);

        assertEquals("总计：12.34(元)\n", result);

    }

    private Product createProduct(String name, String unit, double price) {
        Product product = mock(Product.class);
        when(product.getName()).thenReturn(name);
        when(product.getUnit()).thenReturn(unit);
        when(product.getPrice()).thenReturn(price);
        return product;
    }
}
