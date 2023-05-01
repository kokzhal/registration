package kz.team3.registration.repository;


import kz.team3.registration.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, String> {
    @Query(value = "SELECT * FROM beds WHERE status = 'available' LIMIT 1", nativeQuery = true)
    Bed findAvailableBed();
}
