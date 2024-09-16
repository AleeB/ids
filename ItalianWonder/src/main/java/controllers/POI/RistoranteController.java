package controllers.POI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.POI.RistoranteService;

@RestController
@RequestMapping(path = "api/v1/ristorante")

public class RistoranteController {
    private final RistoranteService ristoranteService;

    public RistoranteController(RistoranteService ristoranteService) {
        this.ristoranteService = ristoranteService;
    }
}
