package de.hsw.kennzeichen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.kennzeichen.dto.EinloesenRequest;
import de.hsw.kennzeichen.dto.KennzeichenResponse;
import de.hsw.kennzeichen.dto.ReservierenRequest;
import de.hsw.kennzeichen.services.KennzeichenService;

@RestController
public class KennzeichenController {

    private KennzeichenService service;

    @Autowired
    public KennzeichenController(KennzeichenService service) {
        this.service = service;
    }

    @GetMapping(path = "/kennzeichen/check-vergeben")
    public boolean isVergeben(@RequestParam String kennzeichen) {
        return service.isVergeben(kennzeichen);
    }

    @GetMapping(path = "/kennzeichen/check-reserviert")
    public boolean isReserviert(@RequestParam String kennzeichen) {
        return service.isReserviert(kennzeichen);
    }

    @PostMapping(path = "/kennzeichen/reservieren")
    @ResponseBody
    public String reservieren(@RequestBody ReservierenRequest request) {
        return service.reservieren(request.getKennzeichen());
    }

    @PostMapping(path = "/kennzeichen/einloesen")
    public void einloesen(@RequestBody EinloesenRequest request) {
        service.einloesen(request.getKennzeichen(), request.getToken());
    }

    @GetMapping(path = "/kennzeichen")
    public KennzeichenResponse lesen(@RequestParam String kennzeichen) {
        return new KennzeichenResponse(service.findKennzeichen(kennzeichen));
    }
    
}
