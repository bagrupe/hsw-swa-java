package de.hsw.iban.utils;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.hsw.iban.dto.IbanResponse;
import de.hsw.iban.dto.IbanError;

/**
 * Utilityklasse für Validierung und Zusammensetzen von IBANs
 */
public class IbanUtil {
    private static final Logger log = Logger.getLogger(IbanUtil.class.getName());

    /**
     * IBAN aus Ländercode, Kontonummer und BLZ erstellen und gleichzeitig
     * validieren
     * 
     * @param countryCode
     * @param accountNumber
     * @param bankIdentification
     * @return
     */
    public static IbanResponse create(String countryCode, String accountNumber, String bankIdentification) {
        log.log(Level.INFO, String.format("Country: %1$s BankID: %2$8s Account: %3$10s", countryCode,
                bankIdentification, accountNumber));

        Set<IbanError> validationErrors = new HashSet<>();

        if (countryCode == null) {
            validationErrors.add(IbanError.NO_COUNTRY_CODE);
        } else if (!countryCode.equals("DE")) {
            validationErrors.add(IbanError.UNIMPLEMENTED_COUNTRY_CODE);
        }

        if (accountNumber == null) {
            validationErrors.add(IbanError.NO_ACCOUNT_NUMBER);
        } else if (accountNumber.length() > 10 || accountNumber.replace("0", "").isEmpty()) {
            validationErrors.add(IbanError.BAD_ACCOUNT_NUMBER);
        }

        if (bankIdentification == null) {
            validationErrors.add(IbanError.NO_BANKID);
        } else if (bankIdentification.startsWith("0") || bankIdentification.startsWith("9")
                || bankIdentification.length() != 8) {
            validationErrors.add(IbanError.BAD_BANKID);
        }

        if (validationErrors.isEmpty()) {
            try {
                String checkIban = String.format("%1$s%2$10s%3$d", bankIdentification, accountNumber, 131400).replace(" ", "0");
                long checkDigit = new BigInteger(checkIban).remainder(new BigInteger("97")).longValue();
    
                String iban = String
                        .format("%1$s%2$02d%3$s%4$10s", countryCode, checkDigit, bankIdentification, accountNumber)
                        .replace(" ", "0");
                log.log(Level.INFO, String.format("Country: %1$s BankID: %2$8s Account: %3$10s => IBAN: %4$s", countryCode,
                        bankIdentification, accountNumber, iban));
    
                return IbanResponse.ofSuccess(iban);
            } catch(NumberFormatException e) {
                validationErrors.add(IbanError.BAD_FORMAT);
            }          
        }

        return IbanResponse.ofFailure("<invalid>", "Iban creation failed", validationErrors);
    }

    /**
     * IBAN validieren
     * 
     * @param iban vollständige IBAN
     * @return true wenn die IBAN valide ist (Prüfziffer stimmt, Komponenten sind
     *         valide)
     */
    public static IbanResponse validate(String iban) {
        log.log(Level.INFO, "Prüfe IBAN: " + iban);

        Set<IbanError> validationErrors = new HashSet<>();

        if (iban == null) {
            validationErrors.add(IbanError.NO_IBAN);
        }

        if (iban.length() != 22) {
            validationErrors.add(IbanError.BAD_IBAN_LENGTH);
        } else {
            String countryCode = iban.substring(0, 2);
            String bankIdentification = iban.substring(4, 12);
            String accountNumber = iban.substring(12, 22);

            if (!iban.equals(create(countryCode, accountNumber, bankIdentification).getIban())) {
                validationErrors.add(IbanError.BAD_IBAN_CHECKDIGIT);
            }

        }

        if (validationErrors.isEmpty()) {
            return IbanResponse.ofSuccess(iban);
        }

        return IbanResponse.ofFailure(iban, "Iban validation failed", validationErrors);
    }

}
