package it.unicam.cs.ItalianWonder.controllers;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.controllers.users.TuristaController;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.SegnalazioneService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/segnalazione")
public class SegnalazioneController {
    private final SegnalazioneService segnalazioneService;
    private final TuristaService turistaService;

    @Autowired
    public SegnalazioneController(SegnalazioneService segnalazioneService, TuristaService turistaService) {
        this.segnalazioneService = segnalazioneService;
        this.turistaService = turistaService;
    }

    @RequestMapping(value = "/newSegnalazione", method = RequestMethod.POST)
    public ResponseEntity<String> addSegnalazione(@RequestBody Segnalazione segnalazione) {
        if(turistaService.login(segnalazione.getTurista().getUserName(), segnalazione.getTurista().getPassword()).isEmpty()){
            return ResponseEntity.badRequest().body("couldn't find user");
        }
        segnalazioneService.addNewSegnalazione(segnalazione);
        return ResponseEntity.ok("Segnalazione added");
    }

}