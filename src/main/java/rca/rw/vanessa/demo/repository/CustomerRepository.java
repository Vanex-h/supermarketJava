package rca.rw.vanessa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rca.rw.vanessa.demo.models.Customer;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Query("SELECT u FROM Customer u WHERE u.firstname= ?1")
    Optional<Customer> findCustomerByFirstname(String firstname);
    Optional<Customer> findByEmail(String email);
}
