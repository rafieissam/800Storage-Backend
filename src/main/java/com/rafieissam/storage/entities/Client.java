package com.rafieissam.storage.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;
// import java.util.List;

@Table(name = "clients")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column()
    private String mobile;

    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    // private List<Sale> sales;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    // public List<Sale> getSales() {
    //     return sales;
    // }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Client setId(Integer id) {
        this.id = id;
        return this;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Client setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    // public Client setSales(List<Sale> sales) {
    //     this.sales = sales;
    //     return this;
    // }

    public Client setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Client setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", mobile=" + mobile +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}