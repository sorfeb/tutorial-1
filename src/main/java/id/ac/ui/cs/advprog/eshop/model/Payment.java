package id.ac.ui.cs.advprog.eshop.model;

import lombok.Builder;
import lombok.Getter;
import enums.PaymentStatus;
import enums.PaymentMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    public Payment(String id, String method, Map<String, String> paymentData) {
        if (id == null || method == null || paymentData == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.method = method;
        this.status = PaymentStatus.PENDING.getValue();

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.paymentData = paymentData;
    }

    public Payment(String id, String method, String status, Map<String, String> paymentData) {
        this(id, method, paymentData);
        this.setStatus();
    }

    private boolean isValidVoucherCode(String voucherCode) {
        return voucherCode.length() == 16
                && voucherCode.startsWith("ESHOP")
                && voucherCode.substring(5).replaceAll("\\D", "").matches("\\d{8}");
    }

    private boolean isValidCashOnDelivery(String address, String deliveryFee){
        return address != null
                && !address.isEmpty()
                && deliveryFee != null
                && !deliveryFee.isEmpty();
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }

    //Set Status according to paymentData
    public void setStatus() {
        if (!PaymentStatus.contains(this.method)) {
            throw new IllegalArgumentException();
        } else if (this.method.equals(PaymentMethod.VOUCHER.getValue())) {
            if (isValidVoucherCode(paymentData.get("voucherCode"))) {
                this.status = PaymentStatus.SUCCESS.getValue();
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }

        } else if (this.method.equals(PaymentMethod.CASH_ON_DELIVERY.getValue())) {
            if (isValidCashOnDelivery(paymentData.get("address"), paymentData.get("deliveryFee"))) {
                this.status = PaymentStatus.SUCCESS.getValue();
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }
        }
    }
}
