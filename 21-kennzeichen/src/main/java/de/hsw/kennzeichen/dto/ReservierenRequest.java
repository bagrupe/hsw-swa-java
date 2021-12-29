package de.hsw.kennzeichen.dto;

public class ReservierenRequest {
    private String kennzeichen;

    public ReservierenRequest() {
    }

    public ReservierenRequest(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    
}
