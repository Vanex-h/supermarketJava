package rca.rw.vanessa.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.rw.vanessa.demo.models.Purchased;
import rca.rw.vanessa.demo.services.PurchasedService;

import java.util.List;

@RestController
@RequestMapping("/api/purchased")
public class PurchasedController {

    private final PurchasedService purchasedService;

    @Autowired
    public PurchasedController(PurchasedService purchasedService) {
        this.purchasedService = purchasedService;
    }

    @GetMapping
    public List<Purchased> getAllPurchased() {
        return purchasedService.getAllPurchased();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchased> getPurchasedById(@PathVariable Long id) {
        return purchasedService.getPurchasedById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Purchased createPurchased(@RequestBody Purchased purchased) {
        return purchasedService.savePurchased(purchased);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purchased> updatePurchased(@PathVariable Long id, @RequestBody Purchased purchased) {
        return purchasedService.getPurchasedById(id)
                .map(existingPurchased -> {
                    existingPurchased.setDate(purchased.getDate());
                    existingPurchased.setQuantity(purchased.getQuantity());
                    existingPurchased.setTotal(purchased.getTotal());
                    return ResponseEntity.ok(purchasedService.savePurchased(existingPurchased));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchased(@PathVariable Long id) {
        purchasedService.deletePurchased(id);
        return ResponseEntity.noContent().build();
    }
}