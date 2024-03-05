package id.ac.ui.cs.advprog.eshop.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    OrderRepository orderRepository;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        this.orders = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product2);

        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                products, 1708570000L, "Safira Sudrajat");
        orders.add(order2);
        Order order3 = new Order("e334ef40-9eff-4da8-9487-8ee697ecbf1e",
                products, 1708570000L, "Bambang Sudrajat");
        orders.add(order3);
    }

    @Test //Unhappy: Test to create payment with empty data
    void testCreatePaymentEmptyPaymentData(){
        Map<String, String> paymentData = new HashMap<>();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                    "VOUCHER", "SUCCESS", paymentData);
        });
    }

    @Test //Happy: Test to create payment status of "SUCCESS"
    void testCreatePaymentSuccessStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                "VOUCHER", "SUCCESS", paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test //Unhappy: Test to create payment with invalid method
    void testCreatePaymentInvalidMethod() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        assertThrows (IllegalArgumentException.class, () -> {
            Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                    "HUTANG", "SUCCESS", paymentData);
        });
    }

    @Test //Happy: Test to automatically set payment status to failed
    void testCreatePaymentInvalidPaymentData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESH");

        Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                "VOUCHER", "SUCCESS", paymentData);
        assertEquals("FAILED", payment.getStatus());
    }
}
