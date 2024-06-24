package rca.rw.vanessa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rca.rw.vanessa.demo.models.Customer;
import rca.rw.vanessa.demo.models.Purchased;

import java.util.Optional;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, Long> {
    @Query("SELECT u FROM Purchased u WHERE u.id= ?1")
    Optional<Customer> findPurchasedById(Long id);
}
