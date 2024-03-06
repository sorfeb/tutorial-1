package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import enums.PaymentMethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class PaymentRepositoryTest {

    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        payments = new ArrayList<>();

        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                paymentData);
        payments.add(payment1);

        paymentData.clear();
        paymentData.put("address", "Depok");
        paymentData.put("deliveryFee", "5000");
        Payment payment2 = new Payment("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                PaymentMethod.CASH_ON_DELIVERY.getValue(),
                paymentData);
        payments.add(payment2);

        paymentData.clear();
        paymentData.put("address", "Jakarta");
        paymentData.put("deliveryFee", "1000");
        Payment payment3 = new Payment("e334ef40-9eff-4da8-9487-8ee697ecbf1e",
                PaymentMethod.CASH_ON_DELIVERY.getValue(),
                paymentData);
        payments.add(payment3);
    }

    @Test //Happy: Test update saved payment in paymentRepository
    void testSave() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
    }

    @Test //Happy: Test if payment is saved to the same repository, it will be updated
    void testSaveUpdate() {
        Payment payment = payments.get(1);
        paymentRepository.save(payment);

        Payment newPayment = new Payment(
                payment.getId(), payment.getMethod(), payment.getPaymentData()
        );
        Payment result = paymentRepository.save(newPayment);

        Payment findResult = paymentRepository.findById(payment.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
    }

    @Test //Happy: Use findById then found
    void testFindByIdIfIdFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
        assertEquals(payments.get(1).getPaymentData(), findResult.getPaymentData());
    }

    @Test //Unhappy: Use findById but not found
    void testFindByIdIfIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test //Happy: Use findAll to match all saved payments
    void testFindAllMoreThanOneProduct() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Iterator<Payment> paymentIterator = paymentRepository.findAll();

        assertTrue(paymentIterator.hasNext());

        Payment savedPayment = paymentIterator.next();
        assertEquals(payments.getFirst().getId(), savedPayment.getId());
        assertEquals(payments.getFirst().getMethod(), savedPayment.getMethod());
        assertEquals(payments.getFirst().getStatus(), savedPayment.getStatus());
        assertEquals(payments.getFirst().getPaymentData(), savedPayment.getPaymentData());

        savedPayment = paymentIterator.next();
        assertTrue(paymentIterator.hasNext());

        savedPayment = paymentIterator.next();

        assertFalse(paymentIterator.hasNext());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Payment> paymentIterator = paymentRepository.findAll();
        assertFalse(paymentIterator.hasNext());
    }
}
