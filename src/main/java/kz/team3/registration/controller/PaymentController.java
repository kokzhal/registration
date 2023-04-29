package kz.team3.registration.controller;


import kz.team3.registration.dto.PaymentRequest;
import kz.team3.registration.entity.Payment;
import kz.team3.registration.entity.Room;
import kz.team3.registration.service.PaymentService;
import kz.team3.registration.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/rooms")
    public List<Payment> getRooms() {
        return paymentService.getPayments();
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        List<Payment> payments = paymentService.getPayments();
        return ResponseEntity.ok(payments);
    }

    @PostMapping
    public ResponseEntity<Void> addPayment(@RequestBody PaymentRequest request) {
        paymentService.savePayment(request.getPaymentType(), request.getPaymentAmount());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
