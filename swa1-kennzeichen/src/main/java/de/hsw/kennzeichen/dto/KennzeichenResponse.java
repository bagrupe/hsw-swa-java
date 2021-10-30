package de.hsw.kennzeichen.dto;

import de.hsw.kennzeichen.beans.Kennzeichen;

public class KennzeichenResponse {
    private String kennzeichen;

    private boolean reserviert;

    private boolean vergeben;

    public KennzeichenResponse(Kennzeichen kennz) {
        this.kennzeichen = kennz.getKennzeichen();
        this.reserviert = kennz.isReserviert();
        this.vergeben = kennz.isVergeben();
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

    
}
