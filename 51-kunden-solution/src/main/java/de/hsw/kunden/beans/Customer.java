package de.hsw.kunden.beans;

import java.time.LocalDate;

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
@Table(name="T_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String password;

    @Column
    private String prename;

    @Column
    private String surname;

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

}
