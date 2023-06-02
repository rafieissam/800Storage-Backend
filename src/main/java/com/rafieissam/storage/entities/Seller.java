package com.rafieissam.storage.entities;

// import java.util.List;

import jakarta.persistence.*;

@Table(name = "sellers")
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    // @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    // private List<Sale> sales;

    public Integer getId() {
        return id;
    }

    // public List<Sale> getSales() {
    //     return sales;
    // }

    public Seller setId(Integer id) {
        this.id = id;
        return this;
    }

    // public Seller setSales(List<Sale> sales) {
    //     this.sales = sales;
    //     return this;
    // }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                '}';
    }
}