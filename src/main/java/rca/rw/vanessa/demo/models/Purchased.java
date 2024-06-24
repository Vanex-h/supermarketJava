package rca.rw.vanessa.demo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchased_items")
public class Purchased {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private Product product;

    @Transient
    private String productCode;

//    @ManyToOne
//    @JoinColumn(name = "quantity_id")
//    private Quantity quantity;
    private Integer quantity;
    private Integer total;
    private Date date;
    public Purchased() {

    }

    public Purchased(Product product, String productCode, Integer quantity, Integer total, Date date) {
        this.product = product;
        this.productCode = product != null ? product.getCode() : null;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        Integer price = product.getPrice();
//        Integer quantity = this.quantity.getQuantity();
        total = Math.round(price * quantity);
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
