package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import enums.OrderStatus;
import enums.PaymentStatus;
import enums.PaymentMethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    OrderServiceImpl paymentService;
    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderRepository paymentRepository;
    List<Order> orders;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", products,
                1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078", products,
                1708570000L, "Safira Sudrajat");
        orders.add(order2);

        payments = new ArrayList<>();

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP1234ABC567A");
        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(), paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("address", "Depok");
        paymentData2.put("deliveryFee", "5000");
        Payment payment2 = new Payment("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                PaymentMethod.CASH_ON_DELIVERY.getValue(), paymentData2);
        payments.add(payment2);
    }

    @Test //Happy: Test AddPayment Successful
    void testAddPayment() {
        Order order = orders.getFirst();
        Payment payment = payments.getFirst();
        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment resultPayment = paymentService.addPayment(
                orders.getFirst(),
                payments.getFirst().getMethod(),
                payments.getFirst().getPaymentData()
        );

        assertNotNull(resultPayment);
        verify(paymentRepository, times(1)).save(any(Payment.class));
        assertEquals(resultPayment.getId(), orders.getFirst().getId());
        assertEquals(resultPayment.getStatus(), PaymentStatus.SUCCESS.getValue());
    }

    @Test //Happy: Test set Payment status to an invalid status
    void testSetStatusFailed() {
        Payment payment = payments.getFirst();

        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.setStatus(payment, "MEOW");
        });
        verify(orderRepository, times(0)).save(any(Order.class));
        verify(paymentRepository, times(0)).save(any(Payment.class));
    }

    @Test //Happy: Test get payment function success
    void testGetPayment() {
        Payment payment = payments.get(1);

        Payment result = paymentService.getPayment(payment.getId());
        verify(paymentRepository, times(1)).findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test //Unhappy: Test get payment function not found
    void testGetPaymentIfNotFound() {
        doReturn(null).when(paymentRepository).findById("zczc");
        assertNull(paymentService.getPayment("zczc"));
    }

    @Test //Happy: Test get payment all success
    void testGetAllPayments() {
        doReturn(payments).when(paymentRepository).findAll();

        List<Payment> result = paymentService.getAllPayments();
        verify(paymentRepository, times(1)).findAll();
        assertEquals(payments, result);
    }

    @Test //Unhappy: Test get payment all null
    void testGetAllPaymentsEmpty() {
        doReturn(new ArrayList<Payment>()).when(paymentRepository).findAll();

        List<Payment> result = paymentService.getAllPayments();
        verify(paymentRepository, times(1)).findAll();
        assertEquals(new ArrayList<Payment>(), result);
    }
}
