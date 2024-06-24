package rca.rw.vanessa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rca.rw.vanessa.demo.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}