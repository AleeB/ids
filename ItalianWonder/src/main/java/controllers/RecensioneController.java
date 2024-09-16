package controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.RecensioneService;

@RestController
@RequestMapping(path = "api/v1/recensione")

public class RecensioneController {
    private final RecensioneService recensioneService;

    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }
}
