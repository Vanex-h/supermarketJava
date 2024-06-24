package rca.rw.vanessa.demo.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rca.rw.vanessa.demo.models.Customer;
import rca.rw.vanessa.demo.models.Product;

import java.util.Optional;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT u FROM Product u WHERE u.name= ?1")
    Optional<Product> findProductByName(String name);

    Optional<Product> findByCode(String code);
}
