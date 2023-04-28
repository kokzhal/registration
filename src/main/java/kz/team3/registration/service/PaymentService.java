package kz.team3.registration.service;

import kz.team3.registration.entity.Payment;
import kz.team3.registration.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void savePayment(String paymentType, double amount) {
        Payment payment = new Payment();
        payment.setPaymentType(paymentType);
        payment.setPaymentAmount(amount);
        payment.setPaymentDate(new Date());
        paymentRepository.save(payment);
    }

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }
}
