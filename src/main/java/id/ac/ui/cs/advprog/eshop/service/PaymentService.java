import id.ac.ui.cs.advprog.eshop.model.*;

import java.util.Map;

public interface PaymentService {
    public Payment addPayment(Order order, String method, Map<String, String> paymentData);

    public setStatus(Payment payment, String status);

    public Payment getPayment(String paymentId);
    public Payment getAllPayment();
}