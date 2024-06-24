package rca.rw.vanessa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rca.rw.vanessa.demo.models.Cart;
import rca.rw.vanessa.demo.models.Customer;
import rca.rw.vanessa.demo.models.Product;
import rca.rw.vanessa.demo.repository.CartRepository;
import rca.rw.vanessa.demo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public CartService(CartRepository cartRepository, ProductService productService, CustomerService customerService, CustomerRepository customerRepository){
        this.cartRepository = cartRepository;
        this.customerRepository= customerRepository;
        this.productService = productService;
        this.customerService = customerService;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart saveCart(Cart cart) {
        Product product = this.productService.getProductByCode(cart.getProductCode()).orElseThrow();
        Customer customer = this.customerRepository.findById(cart.getCustomerId()).orElseThrow();

        cart.setCustomer(customer);
        cart.setProduct(product);
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}