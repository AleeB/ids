package it.unicam.cs.ItalianWonder.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.SegnalazioneService;

@RestController
@RequestMapping(path = "api/v1/segnalazione")

public class SegnalazioneController {
    private final SegnalazioneService segnalazioneService;

    @Autowired
    public SegnalazioneController(SegnalazioneService segnalazioneService) {
        this.segnalazioneService = segnalazioneService;
    }
}
