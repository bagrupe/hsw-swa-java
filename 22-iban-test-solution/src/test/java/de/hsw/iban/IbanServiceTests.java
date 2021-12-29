package de.hsw.iban;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.hsw.iban.dto.IbanError;
import de.hsw.iban.services.IbanService;

@SpringBootTest
public class IbanServiceTests {

    @Autowired
    private IbanService service;

    /**
     * Tests für erfolgreiche Kombinationen - in der Regel einzelne Tests aber hier in einen Test zusammengeführt
     */
    @Test
    public void createTests() {
        assertEquals("DE15111111110000000001", service.createIban("DE", "1", "11111111").getIban());
        assertEquals("DE38222222220000000001", service.createIban("DE", "01", "22222222").getIban());
        assertEquals("DE45333333330000000101", service.createIban("DE", "101", "33333333").getIban());
        assertEquals("DE68444444440000000101", service.createIban("DE", "0101", "44444444").getIban());
        assertEquals("DE43555555550000010101", service.createIban("DE", "10101", "55555555").getIban());
        assertEquals("DE66666666660000010101", service.createIban("DE", "010101", "66666666").getIban());
        assertEquals("DE42777777770001010101", service.createIban("DE", "1010101", "77777777").getIban());
        assertEquals("DE65888888880001010101", service.createIban("DE", "01010101", "88888888").getIban());
        assertEquals("DE21888888880101010101", service.createIban("DE", "101010101", "88888888").getIban());
        assertEquals("DE21888888880101010101", service.createIban("DE", "0101010101", "88888888").getIban());
        assertEquals("DE33888888881010101010", service.createIban("DE", "1010101010", "88888888").getIban());
    }

    /**
     * Tests für ungültige Parameter - in der Regel einzelne Tests aber hier in einen Test zusammengeführt
     */
    @Test
    public void createFailTests() {
        assertTrue(service.createIban(null, "1234567890", "12345678").getErrors().contains(IbanError.NO_COUNTRY_CODE));
        assertTrue(service.createIban("DE", null, "12345678").getErrors().contains(IbanError.NO_ACCOUNT_NUMBER));
        assertTrue(service.createIban("DE", "1234567890", null).getErrors().contains(IbanError.NO_BANKID));

        assertTrue(service.createIban("", "1234567890", "12345678").getErrors().contains(IbanError.UNIMPLEMENTED_COUNTRY_CODE));
        assertTrue(service.createIban("DE", "", "12345678").getErrors().contains(IbanError.BAD_ACCOUNT_NUMBER));
        assertTrue(service.createIban("DE", "1234567890", "").getErrors().contains(IbanError.BAD_BANKID));

        assertTrue(service.createIban("DEX", "1234567890", "12345678").getErrors().contains(IbanError.UNIMPLEMENTED_COUNTRY_CODE));
        assertTrue(service.createIban("DE", "123456789012", "12345678").getErrors().contains(IbanError.BAD_ACCOUNT_NUMBER));
        assertTrue(service.createIban("DE", "1234567890", "1234567812").getErrors().contains(IbanError.BAD_BANKID));

        assertTrue(service.createIban("00", "1234567890", "12345678").getErrors().contains(IbanError.UNIMPLEMENTED_COUNTRY_CODE));
        assertTrue(service.createIban("DE", "XXXXX", "12345678").getErrors().contains(IbanError.BAD_FORMAT));
        assertTrue(service.createIban("DE", "1234567890", "XXX").getErrors().contains(IbanError.BAD_BANKID));

        assertTrue(service.createIban("DE", "1234567890", "00000000").getErrors().contains(IbanError.BAD_BANKID));
        assertTrue(service.createIban("DE", "1234567890", "99999999").getErrors().contains(IbanError.BAD_BANKID));
    }

    @Test
    public void validateTest() {
        assertTrue(service.checkIban("DE11123456781234567890").isValid());
    }

    @Test
    public void validateFailTest() {
        assertFalse(service.checkIban("DE22123456781234567890").isValid());
    }


}
