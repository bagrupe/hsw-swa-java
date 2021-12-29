package de.hsw.iban.dto;

import java.util.HashSet;
import java.util.Set;

public class IbanResponse {
    private String iban;
    private boolean valid;
    private String message;
    private Set<IbanError> errors;

    public IbanResponse() {}

    public static IbanResponse ofSuccess(String iban) {
        return new IbanResponse(iban, true, "IBAN is valid", new HashSet<>());
    }

    public static IbanResponse ofFailure(String iban, String message, Set<IbanError> errors) {
        return new IbanResponse(iban, false, message, errors);
    }

    public IbanResponse(String iban, boolean valid, String message, Set<IbanError> errors) {
        this.iban = iban;
        this.valid = valid;
        this.message = message;
        this.errors = errors;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<IbanError> getErrors() {
        return errors;
    }

    public void setErrors(Set<IbanError> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "IbanResponse [errors=" + errors + ", iban=" + iban + ", message=" + message + ", valid=" + valid + "]";
    }

}
