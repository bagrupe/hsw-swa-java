package de.hsw.jpa.beans;

import java.time.LocalDate;

public class Customer {

    private long id;

    private String name;

    private LocalDate birthDate;

    public Customer() {
    }

    public Customer(long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }
}
