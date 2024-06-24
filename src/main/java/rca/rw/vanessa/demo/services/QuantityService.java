package rca.rw.vanessa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rca.rw.vanessa.demo.models.Product;
import rca.rw.vanessa.demo.models.Quantity;
import rca.rw.vanessa.demo.repository.QuantityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuantityService {

    private final QuantityRepository quantityRepository;
    private final ProductService productService;

    @Autowired
    public QuantityService(QuantityRepository quantityRepository, ProductService productService) {
        this.quantityRepository = quantityRepository;
        this.productService = productService;
    }

    public List<Quantity> getAllQuantities() {
        return quantityRepository.findAll();
    }

    public Optional<Quantity> getQuantityById(Long id) {
        return quantityRepository.findById(id);
    }

    public Quantity saveQuantity(Quantity quantity) {
        Product product = this.productService.getProductByCode(quantity.getProductCode()).orElseThrow();
        quantity.setProduct(product);
        return quantityRepository.save(quantity);
    }

    public void deleteQuantity(Long id) {
        quantityRepository.deleteById(id);
    }
}