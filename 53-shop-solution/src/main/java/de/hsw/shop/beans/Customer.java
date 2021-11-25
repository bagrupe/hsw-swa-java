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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String prename;

    @Column
    private String surname;

    @Column
    private String password;

    @Column
    private LocalDate birthdate;

    @Column
    private String street;

    @Column
    private String streetno;

    @Column
    private String zipcode;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String iban;

    @Column
    private boolean active;

    @lombok.ToString.Exclude
    @lombok.EqualsAndHashCode.Exclude
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    public Customer(String prename, String surname, String password, LocalDate birthdate, String street,
            String streetno, String zipcode, String city, String country, String iban, boolean active) {
        this.prename = prename;
        this.surname = surname;
        this.password = password;
        this.birthdate = birthdate;
        this.street = street;
        this.streetno = streetno;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.iban = iban;
        this.active = active;
    }

}
