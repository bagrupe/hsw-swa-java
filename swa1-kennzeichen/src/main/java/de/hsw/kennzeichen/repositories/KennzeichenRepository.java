package de.hsw.kennzeichen.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.kennzeichen.beans.Kennzeichen;

@Repository
public interface KennzeichenRepository extends CrudRepository<Kennzeichen, Long> {
    public Optional<Kennzeichen> findByKennzeichen(String kennzeichen);
}
