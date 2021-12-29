package de.hsw.iban.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.iban.dto.IbanRequest;
import de.hsw.iban.dto.IbanResponse;
import de.hsw.iban.services.IbanService;

@CrossOrigin
@RestController
public class IbanController {
    private static final Logger log = Logger.getLogger(IbanController.class.getName());
    
    private IbanService service;

    @Autowired
    public IbanController(IbanService service) {
        this.service = service;
    }

    // Powershell: invoke-restmethod -Method GET -Uri "http://localhost:8080/api/ValidateIban?iban=DE75888888880000012345"
    @GetMapping(path = "/api/ValidateIban")
    public ResponseEntity<IbanResponse> validateIban(@RequestParam String iban) {
        log.log(Level.INFO, "ValidateIban Request: " + iban);
        ResponseEntity<IbanResponse> responseEntity;

        IbanResponse response = service.checkIban(iban);

        if(response.isValid()) {
            responseEntity = ResponseEntity.ok(response);
        } else {
            responseEntity = ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
        }

        log.log(Level.INFO, "ValidateIban Response: " + responseEntity.getBody());
        return responseEntity;
    }

    // Powershell: invoke-restmethod -Method POST -Uri "http://localhost:8080/api/CreateIban" -Body "{`"countryCode`":`"DE`", `"accountNumber`":`"12345`", `"bankIdentification`":`"88888888`"}" -ContentType "application/json"
    // @RequestBody wird im JSON Format erwartet und nicht x-www-form-urlencoded
    @PostMapping(path = "/api/CreateIban")
    public ResponseEntity<IbanResponse> createIban(@RequestBody IbanRequest request) {
        log.log(Level.INFO, "CreateIban POST: " + request);
        ResponseEntity<IbanResponse> responseEntity;

        IbanResponse response = service.createIban(request.getCountryCode(), request.getAccountNumber(), request.getBankIdentification());

        if(response.isValid()) {
            responseEntity = ResponseEntity.ok(response);
        } else {
            responseEntity = ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
        }

        log.log(Level.INFO, "CreateIban Response: " + responseEntity.getBody());
        return responseEntity;
    }

    // Powershell: invoke-restmethod -Method GET -Uri "http://localhost:8080/api/CreateIban?countryCode=DE&accountNumber=12345&bankIdentification=88888888"
    @GetMapping(path = "/api/CreateIban")
    public ResponseEntity<IbanResponse> createIbanGet(@RequestParam String countryCode, @RequestParam String accountNumber, @RequestParam String bankIdentification) {
        log.log(Level.INFO, "CreateIban GET: " + countryCode + "/"+bankIdentification+"/"+accountNumber);
        ResponseEntity<IbanResponse> responseEntity;

        IbanResponse response = service.createIban(countryCode, accountNumber, bankIdentification);

        if(response.isValid()) {
            responseEntity = ResponseEntity.ok(response);
        } else {
            responseEntity = ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
        }

        log.log(Level.INFO, "CreateIban Response: " + responseEntity.getBody());
        return responseEntity;
    }
}
