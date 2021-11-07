package de.hsw.kennzeichen.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_KENNZEICHEN")
public class Kennzeichen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String kennzeichen;

    @Column
    private boolean reserviert;

    @Column
    private boolean vergeben;

    @Column
    private String token;

    public Kennzeichen() {
    }

    public Kennzeichen(String kennzeichen, boolean reserviert, boolean vergeben) {
        this.kennzeichen = kennzeichen;
        this.reserviert = reserviert;
        this.vergeben = vergeben;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public boolean isReserviert() {
        return reserviert;
    }

    public void setReserviert(boolean reserviert) {
        this.reserviert = reserviert;
    }

    public boolean isVergeben() {
        return vergeben;
    }

    public void setVergeben(boolean vergeben) {
        this.vergeben = vergeben;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
