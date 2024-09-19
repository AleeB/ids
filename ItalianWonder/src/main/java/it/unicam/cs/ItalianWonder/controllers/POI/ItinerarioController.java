package it.unicam.cs.ItalianWonder.controllers.POI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.POI.ItinerarioService;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/itinerario")

public class ItinerarioController {

    private final ItinerarioService itinerarioService;

    @Autowired
    public ItinerarioController(ItinerarioService itinerarioService) {
        this.itinerarioService = itinerarioService;
    }

    @RequestMapping(value = "")
    public ResponseEntity<String> addNewItinerario(@RequestBody Map<String, Map<String, Object>> map){

    }

}
