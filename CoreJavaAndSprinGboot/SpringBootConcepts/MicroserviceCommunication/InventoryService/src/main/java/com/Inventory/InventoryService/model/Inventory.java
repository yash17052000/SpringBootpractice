package com.Inventory.InventoryService.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    private Long productId;
    private int quantity;

    // Default (No-args) Constructor (JPA ke liye zaroori hota hai)
    public Inventory() {}

    // Parameterized Constructor
    public Inventory(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setters (Values ko access aur modify karne ke liye)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}