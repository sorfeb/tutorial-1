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
    Map<String, String> paymentData;
    @BeforeEach
    void setUp() {
       paymentData = new HashMap<>();
       paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test //Unhappy: Test to create payment with empty data
    void testCreatePaymentEmptyPaymentData(){
        paymentData.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                    "VOUCHER", "SUCCESS", paymentData);
        });
    }

    @Test //Happy: Test to create payment status of "SUCCESS"
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                "VOUCHER", "SUCCESS", paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test //Unhappy: Test to create payment with invalid method
    void testCreatePaymentInvalidMethod() {
        assertThrows (IllegalArgumentException.class, () -> {
            Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                    "HUTANG", "SUCCESS", paymentData);
        });
    }

    @Test //Happy: Test to automatically set payment status to failed
    void testCreatePaymentInvalidPaymentData() {
        paymentData.put("voucherCode", "ESH");

        Payment payment = new Payment("12345678-012a-4c07-b546-54eb1396d79b",
                "VOUCHER", "SUCCESS", paymentData);
        assertEquals("FAILED", payment.getStatus());
    }
}
