package kz.team3.registration.repository;

import kz.team3.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT s FROM users s WHERE s.email = ?1")
    Optional<User> findFirstByEmail(String email);

}
