package de.hsw.kennzeichen;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.hsw.kennzeichen.utils.KennzeichenValidation;

public class KennzeichenValidationTests {
    @Test
	void validKennzeichen() {
        assertDoesNotThrow(() -> {
            KennzeichenValidation.checkKennzeichen("A-BC-123");
        });
	}

    @Test
	void invalidKennzeichenTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            KennzeichenValidation.checkKennzeichen("A-BC-1234567890");
        });
	}

    @Test
	void invalidKennzeichenWrongFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            KennzeichenValidation.checkKennzeichen("67890");
        });
	}
}
