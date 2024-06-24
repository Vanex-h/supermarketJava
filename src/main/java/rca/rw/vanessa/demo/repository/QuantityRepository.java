package rca.rw.vanessa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rca.rw.vanessa.demo.models.Customer;
import rca.rw.vanessa.demo.models.Quantity;

import java.util.Optional;
@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    @Query("SELECT u FROM Quantity u WHERE u.quantity= ?1")
    Optional<Customer> findQuantityByQuantity(String quantity);
}
