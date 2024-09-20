package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.repositories.POI.ItinerarioRepository;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.POI.ItinerarioService;

import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/itinerario")

public class ItinerarioController {

    private final ItinerarioService itinerarioService;
    private final TuristaService turistaService;
    private final ItinerarioRepository itinerarioRepository;

    @Autowired
    public ItinerarioController(ItinerarioService itinerarioService, TuristaService turistaService, ItinerarioRepository itinerarioRepository) {
        this.itinerarioService = itinerarioService;
        this.turistaService = turistaService;
        this.itinerarioRepository = itinerarioRepository;
    }

    @RequestMapping(value = "/addItinerario", method = RequestMethod.POST)
    public ResponseEntity<String> addNewItinerario(@RequestBody Itinerario itinerario){
        Turista user = turistaService.login(itinerario.getContributor().getUserName(),
                itinerario.getContributor().getPassword()).get();
        return switch (user.getTipoUser()){
            case Contributor:
                itinerario.setApprovazione(false);
                yield ResponseEntity.ok(itinerarioService.addItinerario(itinerario).toString());
            case ContributorAutorizzato, Curatore:
                itinerario.setApprovazione(true);
                yield ResponseEntity.ok(itinerarioService.addItinerario(itinerario).toString());
            default:
                yield ResponseEntity.badRequest().body("itinerario not added. Probably it is already in");
        };
    }

    @RequestMapping(value = "/getItinerarioByApprovazione", method = RequestMethod.POST)
    public ResponseEntity<Optional<List<Itinerario>>> getItinerarioByApprovazione(@RequestBody Map<String, Map<String, Object>> map){
        //se approvazione == true
        if(map.get("itinerario").get("approvazione").toString().equals("true")){
            return ResponseEntity.ok().body((itinerarioService.getItinerariByApprovazione(true)));
        }
        //se approvazione == false
        Turista user = ((Turista) map.get("currentUser"));
        Optional<Turista> foundUser = turistaService.login(user.getUserName(), user.getPassword());
        if(foundUser.isEmpty()){
            return ResponseEntity.badRequest().body(Optional.empty());
        }
        return switch (foundUser.get().getTipoUser()){
            case Contributor, ContributorAutorizzato, Animatore, Curatore, GestoreDellaPiattaforma:
                yield ResponseEntity.ok().body(itinerarioService.getItinerariByApprovazione(true));
            default:
                yield ResponseEntity.badRequest().body(Optional.empty());
        };
    }

}
