package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
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

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/itinerario")

public class ItinerarioController {

    private final ServiceMediator serviceMediator;

    @Autowired
    public ItinerarioController(ServiceMediator serviceMediator) {
        this.serviceMediator = serviceMediator;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity<List<Itinerario>> getAllComuni() {
        return ResponseEntity.ok(serviceMediator.get(Itinerario.class).stream().map(
                item->(Itinerario)item
        ).toList());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addItinerario(@RequestBody BodyTemplate<Itinerario> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        switch (user.getTipoUser()){
            case Contributor: {
                body.getData().setApprovazione(false);
                body.getData().setContributor((Contributor) user);
            }break;
            case ContributorAutorizzato, Curatore: {
                body.getData().setApprovazione(true);
                body.getData().setContributorAutorizzato((ContributorAutorizzato) user);
            }break;
            default: {
                return ResponseEntity.status(401).body("Non Autorizzato");
            }
        }
        serviceMediator.post(body.getData());
        return ResponseEntity.ok("Itinerario Aggiunto");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> updateItinerario(@RequestBody BodyTemplate<Ristorante> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Itinerario Modificato");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> deleteItinerario(@RequestBody BodyTemplate<Itinerario> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.delete(body.getData().getID(), Ristorante.class);
        return ResponseEntity.ok("Itinerario Eliminato");
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ResponseEntity<String> approveItinerario(@RequestBody BodyTemplate<Itinerario> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if (user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");

        body.getData().setApprovazione(true);
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Itinerario Approvato! (Buon pranzo :) )");
    }

}
