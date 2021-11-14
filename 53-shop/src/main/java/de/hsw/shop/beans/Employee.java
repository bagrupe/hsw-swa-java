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
@Table(name = "T_EMPLOYEE")
public class Employee {
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
    private boolean active;

    public Employee(String prename, String surname, String password, boolean active) {
        this.prename = prename;
        this.surname = surname;
        this.password = password;
        this.active = active;
    }

}
