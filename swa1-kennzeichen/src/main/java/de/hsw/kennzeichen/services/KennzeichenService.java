package de.hsw.kennzeichen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.kennzeichen.beans.Kennzeichen;
import de.hsw.kennzeichen.repositories.KennzeichenRepository;
import de.hsw.kennzeichen.utils.KennzeichenValidation;

/**
 * Spring-Boot Service, der dem Controller Methoden zur Verfügung stellt, um mit dem Model zu arbeiten
 * Einheitliches Interface für den Fall, dass es mehrere Controller gibt
 */
@Service
public class KennzeichenService {
    // Durch Autowired im Konstruktor wird durch Spring automatisch injected
    private KennzeichenRepository repository;

    @Autowired
    public KennzeichenService(KennzeichenRepository repository) {
        this.repository = repository;
    }

    /**
     * Holt alle Kennzeichen aus der Datenbank
     * @return Liste mit allen Kennzeichen
     */
    public List<Kennzeichen> findAllKennzeichen() {
        List<Kennzeichen> list = new ArrayList<>();
        Iterable<Kennzeichen> it = repository.findAll();
        for(Kennzeichen db: it) {
            list.add(db);
        }
        return list;
    }

    /**
     * Sucht uns das Kennzeichen aus der DB oder erstellt ein neues Objekt
     * Mit Hilfe einer automatisierten WHERE Bedingung im Repository
     * @param kennzeichen Kennzeichen als String
     * @return Kennzeichenobjekt
     */
    public Kennzeichen findKennzeichen(String kennzeichen) {
        KennzeichenValidation.checkKennzeichen(kennzeichen);

        return repository.findByKennzeichen(kennzeichen).orElseGet(() -> new Kennzeichen(kennzeichen, false, false));
    }

    

    /**
     * Prüft ob das Kennzeichen schon vergeben ist
     * 
     * @param kennzeichen
     * @return
     */
    public boolean isVergeben(String kennzeichen) {
        return findKennzeichen(kennzeichen).isVergeben();
    }

    /**
     * Prüft ob das Kennzeichen reserviert ist
     * 
     * @param kennzeichen
     * @return
     */
    public boolean isReserviert(String kennzeichen) {
        return findKennzeichen(kennzeichen).isReserviert();
    }

    /**
     * Reserviert ein Kennzeichen
     * 
     * @param kennzeichen
     * @return Token, mit dem die Reservierung eingelöst werden kann
     */
    public String reservieren(String kennzeichen) {
        Kennzeichen k = findKennzeichen(kennzeichen);

        if(k.isReserviert()) {
            throw new IllegalArgumentException("Kennzeichen ist bereits reserviert");
        }

        if(k.isVergeben()) {
            throw new IllegalArgumentException("Kennzeichen ist bereits vergeben");
        }

        k.setReserviert(true);
        k.setToken(UUID.randomUUID().toString());
        repository.save(k);
        return k.getToken();
    }

    /**
     * Löst ein Token für die Reservierung ein
     * @param kennzeichen
     * @param token
     * @return
     */
    public void einloesen(String kennzeichen, String token) {
        Kennzeichen k = findKennzeichen(kennzeichen);

        if(!k.isReserviert()){
            throw new IllegalArgumentException("Kennzeichen ist nicht reserviert");
        }

        if(k.isVergeben()){
            throw new IllegalArgumentException("Kennzeichen ist vergeben");
        }

        if(!k.getToken().equals(token)){
            throw new IllegalArgumentException("Falscher Token übergeben");
        }

        k.setReserviert(false);
        k.setVergeben(true);
        k.setToken(null);
        repository.save(k);
    }
}
