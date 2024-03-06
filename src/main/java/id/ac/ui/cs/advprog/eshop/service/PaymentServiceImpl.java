package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceImpl {
    @Autowired
    private PaymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
return null;
    }
    @Override
    public setStatus(Payment payment, String status){
        return null;
    }
    @Override
    public Payment getPayment(String paymentId){
        return null;
    }
    @Override
    public Payment getAllPayment(){
        return null;
    }
}
