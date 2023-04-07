package kz.team3.registration.controller;


import kz.team3.registration.entity.Payment;
import kz.team3.registration.entity.Room;
import kz.team3.registration.service.PaymentService;
import kz.team3.registration.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getRooms() {
        return paymentService.getPayments();
    }
}
