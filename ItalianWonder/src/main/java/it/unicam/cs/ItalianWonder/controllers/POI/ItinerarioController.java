package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/itinerario")

public class ItinerarioController {

    private final ServiceMediator serviceMediator;
    private final TuristaService turistaService;

    @Autowired
    public ItinerarioController(ServiceMediator serviceMediator, TuristaService turistaService) {
        this.serviceMediator = serviceMediator;
        this.turistaService = turistaService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity<List<Itinerario>> getAllItinerari() {
        return ResponseEntity.ok(serviceMediator.get(Itinerario.class).stream().map(
                item->(Itinerario)item
        ).toList());
    }

    @RequestMapping(value = "/getByApprovazione", method = RequestMethod.GET)
    public List<Itinerario> getByApprovazione(@RequestBody BodyTemplate<Boolean> body){
        Turista tur = turistaService.login(body.getUser().getUserName(), body.getUser().getPassword()).orElse(null);
        return switch (tur.getTipoUser()){
            case UserNonAutenticato, Turista, TuristaAutorizzato:
                yield serviceMediator.get(Map.of("approvazione", true), Itinerario.class).stream().map(
                        item->(Itinerario)item
                ).toList();
            case Contributor, ContributorAutorizzato, Animatore, Curatore, GestoreDellaPiattaforma:
                yield serviceMediator.get(Map.of("approvazione", body.getData()), Itinerario.class).stream().map(
                        item->(Itinerario)item
                ).toList();
        };
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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateItinerario(@RequestBody BodyTemplate<Itinerario> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Itinerario Modificato");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteItinerario(@RequestBody BodyTemplate<Itinerario> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.delete(body.getData().getID(), Itinerario.class);
        return ResponseEntity.ok("Itinerario Eliminato");
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ResponseEntity<String> approveItinerario(@RequestBody BodyTemplate<Itinerario> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if (user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");

        body.getData().setApprovazione(true);
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Itinerario Approvato!");
    }

}
