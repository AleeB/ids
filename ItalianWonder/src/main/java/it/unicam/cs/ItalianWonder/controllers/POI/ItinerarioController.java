package it.unicam.cs.ItalianWonder.controllers.POI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.POI.ItinerarioService;

@RestController
@RequestMapping(path = "api/v1/itinerario")

public class ItinerarioController {

    private final ItinerarioService itinerarioService;

    @Autowired
    public ItinerarioController(ItinerarioService itinerarioService) {
        this.itinerarioService = itinerarioService;
    }
}
