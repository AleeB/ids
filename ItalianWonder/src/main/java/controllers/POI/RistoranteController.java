package controllers.POI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.POI.RistoranteService;

@RestController
@RequestMapping(path = "api/v1/ristorante")

public class RistoranteController {

    private final RistoranteService ristoranteService;

    @Autowired
    public RistoranteController(RistoranteService ristoranteService) {
        this.ristoranteService = ristoranteService;
    }
}
