package kz.team3.registration.repository;

import kz.team3.registration.entity.Bed;
import kz.team3.registration.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
