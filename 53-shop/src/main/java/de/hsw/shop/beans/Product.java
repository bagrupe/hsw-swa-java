package de.hsw.shop.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "T_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String shortDescription;

    @Column
    private String longDescription;

    @Column
    private String productImage;

    @Column
    private double price;

    @Column
    private int vat;

    @Column
    private boolean active;

    public Product(String name, String shortDescription, String longDescription, String productImage, double price,
            int vat, boolean active) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.productImage = productImage;
        this.price = price;
        this.vat = vat;
        this.active = active;
    }

}
