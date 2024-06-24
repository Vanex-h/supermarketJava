package rca.rw.vanessa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rca.rw.vanessa.demo.models.Product;
import rca.rw.vanessa.demo.models.Purchased;
import rca.rw.vanessa.demo.repository.PurchasedRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchasedService {

    private final PurchasedRepository purchasedRepository;
    private final ProductService productService;

    @Autowired
    public PurchasedService(PurchasedRepository purchasedRepository, ProductService productService) {
        this.purchasedRepository = purchasedRepository;
        this.productService= productService;
    }

    public List<Purchased> getAllPurchased() {
        return purchasedRepository.findAll();
    }

    public Optional<Purchased> getPurchasedById(Long id) {
        return purchasedRepository.findById(id);
    }

    public Purchased savePurchased(Purchased purchased) {
        Product product= this.productService.getProductByCode(purchased.getProductCode()).orElseThrow();
        purchased.setProduct(product);
        purchased.setTotal(purchased.getTotal()); // set the total
//        purchased.setQuantity(purchased.getQuantity()); // set the quantity
        return purchasedRepository.save(purchased);
    }

    public void deletePurchased(Long id) {
        purchasedRepository.deleteById(id);
    }
}