package rca.rw.vanessa.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.rw.vanessa.demo.models.Quantity;
import rca.rw.vanessa.demo.services.QuantityService;

import java.util.List;

@RestController
@RequestMapping("/api/quantities")
public class QuantityController {

    private final QuantityService quantityService;

    @Autowired
    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @GetMapping
    public List<Quantity> getAllQuantities() {
        return quantityService.getAllQuantities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quantity> getQuantityById(@PathVariable Long id) {
        return quantityService.getQuantityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quantity createQuantity(@RequestBody Quantity quantity) {
        return quantityService.saveQuantity(quantity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quantity> updateQuantity(@PathVariable Long id, @RequestBody Quantity quantity) {
        return quantityService.getQuantityById(id)
                .map(existingQuantity -> {
                    existingQuantity.setQuantity(quantity.getQuantity() );
                    return ResponseEntity.ok(quantityService.saveQuantity(existingQuantity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuantity(@PathVariable Long id) {
        quantityService.deleteQuantity(id);
        return ResponseEntity.noContent().build();
    }
}