package id.ac.ui.cs.advprog.eshop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

    public Payment(String id, String method, String status, Map<String, String> paymentData) {
        if (id == null || method == null || paymentData == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.method = method;
        this.status = status;

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.paymentData = paymentData;

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

    //Set Status according to paymentData
    public void setStatus() {
        String[] paymentMethods = {"VOUCHER", "CASH_ON_DELIVERY"};

        if (Arrays.stream(paymentMethods).noneMatch(item -> (item.equals(this.method)))) {
            throw new IllegalArgumentException();
        } else if (this.method.equals("VOUCHER")) {
            if (isValidVoucherCode(paymentData.get("voucherCode"))) {
                this.status = "SUCCESS";
            } else {
                this.status = "FAILED";
            }
        } else if (this.method.equals("CASH_ON_DELIVERY")) {
            if (isValidCashOnDelivery(paymentData.get("address"), paymentData.get("deliveryFee"))) {
                this.status = "SUCCESS";
            } else {
                this.status = "FAILED";
            }
        }
    }
}
