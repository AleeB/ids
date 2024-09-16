package controllers.POI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.POI.ItinerarioService;

@RestController
@RequestMapping(path = "api/v1/itinerario")

public class ItinerarioController {
    private final ItinerarioService itinerarioService;

    public ItinerarioController(ItinerarioService itinerarioService) {
        this.itinerarioService = itinerarioService;
    }
}
