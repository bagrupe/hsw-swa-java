package de.hsw.shop.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "T_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @ManyToOne
    private Customer customer;

    @Column
    private LocalDate orderDate;

    @Column
    private int orderStatus;

    @Column
    private String iban;

    @lombok.ToString.Exclude
    @lombok.EqualsAndHashCode.Exclude
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Customer customer, LocalDate orderDate, int orderStatus, String iban) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.iban = iban;
    }

}
