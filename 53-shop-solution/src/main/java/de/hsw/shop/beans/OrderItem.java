package de.hsw.shop.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "T_ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "ORDER_ID", nullable = false)
    @ManyToOne
    private Order order;

    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @ManyToOne
    private Product product;

    @Column
    private int amount;

    @Column
    private double price;

    @Column
    private int vat;

    public OrderItem(Order order, Product product, int amount, double price, int vat) {
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.vat = vat;
    }

}
