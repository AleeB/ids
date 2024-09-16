package controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.SegnalazioneService;

@RestController
@RequestMapping(path = "api/v1/segnalazione")

public class SegnalazioneController {
    private final SegnalazioneService segnalazioneService;

    public SegnalazioneController(SegnalazioneService segnalazioneService) {
        this.segnalazioneService = segnalazioneService;
    }
}
