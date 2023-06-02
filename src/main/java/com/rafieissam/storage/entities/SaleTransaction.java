package com.rafieissam.storage.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;

@Table(name = "sale_transactions")
@Entity
public class SaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Sale sale;

    @Column(name = "sale_id")
    private Integer saleId;

    @ManyToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_id")
    private Integer productId;

    @Column()
    private Integer quantity;

    @Column()
    private Float price;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public SaleTransaction setId(int id) {
        this.id = id;
        return this;
    }

    public SaleTransaction setSale(Sale sale) {
        this.sale = sale;
        return this;
    }

    public SaleTransaction setSaleId(Integer saleId) {
        this.saleId = saleId;
        return this;
    }

    public SaleTransaction setProduct(Product product) {
        this.product = product;
        return this;
    }

    public SaleTransaction setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public SaleTransaction setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public SaleTransaction setPrice(float price) {
        this.price = price;
        return this;
    }

    public SaleTransaction setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public SaleTransaction setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
    
    @Override
    public String toString() {
        return "SaleTransaction{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}