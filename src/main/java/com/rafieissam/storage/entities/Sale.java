package com.rafieissam.storage.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;
// import java.util.List;

@Table(name = "sales")
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    @Column(name = "client_id")
    private Integer clientId;

    @ManyToOne()
    @JoinColumn(name = "seller_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Seller seller;

    @Column(name = "seller_id")
    private Integer sellerId;

    // @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<SaleTransaction> transactions;

    @Column()
    private float total;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Seller getSeller() {
        return seller;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    // public List<SaleTransaction> getSaleTransactions() {
    //     return transactions;
    // }

    public float getTotal() {
        return total;
    }

    public Sale setId(int id) {
        this.id = id;
        return this;
    }

    public Sale setClient(Client client) {
        this.client = client;
        return this;
    }

    public Sale setClientId(Integer clientId) {
        this.clientId = clientId;
        return this;
    }

    public Sale setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public Sale setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    // public Sale setSaleTransactions(List<SaleTransaction> transactions) {
    //     this.transactions = transactions;
    //     recalculateTotal();
    //     return this;
    // }

    public Sale setTotal(float total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                '}';
    }

    public void recalculateTotal() {
        // float calculatedTotal = 0.0f;
        // for (SaleTransaction transaction: transactions) {
        //     calculatedTotal += (transaction.getQuantity() * transaction.getPrice());
        // }
        // this.total = calculatedTotal;
    }

}