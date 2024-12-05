package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import it.unicam.cs.ItalianWonder.components.Mediator;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.Turista;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/PuntoRistoro")
public class PuntoRistoroController {
    private final ServiceMediator serviceMediator;

    @Autowired
    public PuntoRistoroController(Mediator serviceMediator) {
      this.serviceMediator = serviceMediator;
    }

    @RequestMapping(value = "/getPuntoRistoro", method = RequestMethod.GET)
    public ResponseEntity<List<PuntoRistoro>> getAllComuni() {
        return ResponseEntity.ok(serviceMediator.get(PuntoRistoro.class).stream().map(
            item->(PuntoRistoro)item
        ).toList());
    }

    @RequestMapping(value = "/getByApprovazione", method = RequestMethod.GET)
    public List<PuntoRistoro> getByApprovazione(@RequestBody BodyTemplate<Boolean> body){
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        return switch (user.getTipoUser()){
            case UserNonAutenticato, Turista, TuristaAutorizzato:
                yield serviceMediator.get(Map.of("approvazione", true), PuntoRistoro.class).stream().map(
                    item->(PuntoRistoro)item
                ).toList();
            case Contributor, ContributorAutorizzato, Animatore, Curatore, GestoreDellaPiattaforma:
                yield serviceMediator.get(Map.of("approvazione", body.getData()), PuntoRistoro.class).stream().map(
                    item->(PuntoRistoro)item
                ).toList();
        };
    }

    @RequestMapping(value = "/postPuntoRistoro", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiPuntoRistoro(@RequestBody BodyTemplate<PuntoRistoro> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        switch (user.getTipoUser()){
            case Contributor : {
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
        return ResponseEntity.ok("PuntoRistoro Aggiunto");
    }

    @RequestMapping(value = "/modificaPuntoRistoro", method = RequestMethod.PUT)
    public ResponseEntity<String> modificaPuntoRistoro(@RequestBody BodyTemplate<PuntoRistoro> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("PuntoRistoro Modificato");
    }

    @RequestMapping(value = "/eliminaPuntoRistoro", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminaPuntoRistoro(@RequestBody BodyTemplate<PuntoRistoro> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.delete(body.getData().getID(), PuntoRistoro.class);
        return ResponseEntity.ok("PuntoRistoro Eliminato");
    }

    @RequestMapping(value = "/approvaPuntoRistoro", method = RequestMethod.POST)
    public ResponseEntity<String> approvaDivertimento(@RequestBody BodyTemplate<PuntoRistoro> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if (user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");

        body.getData().setApprovazione(true);
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("PuntoRistoro Approvato! (Buon pranzo :) )");
    }
}
