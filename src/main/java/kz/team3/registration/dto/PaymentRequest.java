package kz.team3.registration.dto;

public class PaymentRequest {

    private String paymentType;
    private double paymentAmount;


    public PaymentRequest(String paymentType, double paymentAmount) {
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return getPaymentAmount();
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
