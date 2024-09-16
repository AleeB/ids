package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.LocalizzazioneService;

@RestController
@RequestMapping(path = "api/v1/localizzaione")

public class LocalizzazioneController {
    private final LocalizzazioneService localizzazioneService;

    @Autowired
    public LocalizzazioneController(LocalizzazioneService localizzazioneService) {
        this.localizzazioneService = localizzazioneService;
    }
}
