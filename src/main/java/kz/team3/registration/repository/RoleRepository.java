package kz.team3.registration.repository;

import kz.team3.registration.entity.Role;
import kz.team3.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
