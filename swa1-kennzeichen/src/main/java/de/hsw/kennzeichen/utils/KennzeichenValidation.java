package de.hsw.kennzeichen.utils;

public class KennzeichenValidation {
    /**
     * Prüft das Format des Kennzeichens
     * 
     * @param kennzeichen Format AA-BB-1234 (keine Sonderkennzeichen o.ä., maximale Länge 10 mit Bindestrichen)
     * @return
     */
    public static void checkKennzeichen(String kennzeichen) {
        if (kennzeichen == null) {
            throw new IllegalArgumentException("Kennzeichen muss gefüllt sein");
        }

        if (kennzeichen.length() < 5) {
            throw new IllegalArgumentException("Kennzeichen darf nicht kürzer als 5 Zeichen sein");
        }

        if (kennzeichen.length() > 10) {
            throw new IllegalArgumentException("Kennzeichen darf nicht länger als 10 Zeichen sein");
        }
        
        if (!kennzeichen.matches("[A-Z]{1,3}-[A-Z]{1,2}-[0-9]{1,4}")) {
            throw new IllegalArgumentException("Kennzeichen entspricht nicht dem Format AA-BB-1234");
        }
    }
}
