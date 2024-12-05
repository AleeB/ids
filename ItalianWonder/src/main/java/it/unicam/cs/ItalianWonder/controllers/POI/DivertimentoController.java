package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
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
@RequestMapping(path = "api/v1/divertimento")
public class DivertimentoController {
    private final ServiceMediator serviceMediator;

    @Autowired
    public DivertimentoController(Mediator mediatorService) {
      this.serviceMediator = mediatorService;
    }

    @RequestMapping(value = "/getDivertimenti", method = RequestMethod.GET)
    public ResponseEntity<List<Divertimento>> getAllDivertimenti() {
        return ResponseEntity.ok(
            serviceMediator.get(Divertimento.class).stream()
                .map(item-> (Divertimento)item).toList()
        );
    }

    @RequestMapping(value = "/getByApprovazione", method = RequestMethod.GET)
    public List<Divertimento> getByApprovazione(@RequestBody BodyTemplate<Boolean> body){
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        return switch (user.getTipoUser()){
            case UserNonAutenticato, Turista, TuristaAutorizzato:
                yield serviceMediator.get(Map.of("approvazione", true), Divertimento.class).stream().map(
                    item->(Divertimento)item
                ).toList();
            case Contributor, ContributorAutorizzato, Animatore, Curatore, GestoreDellaPiattaforma:
                yield serviceMediator.get(Map.of("approvazione", body.getData()), Divertimento.class).stream().map(
                    item->(Divertimento)item
                ).toList();
        };
    }

    @RequestMapping(value = "/postDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiDivertimento(@RequestBody BodyTemplate<Divertimento> body) {
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
        return ResponseEntity.ok("Divertimento Aggiunto");
    }

    @RequestMapping(value = "/modificaDivertimento", method = RequestMethod.PUT)
    public ResponseEntity<String> modificaDivertimento(@RequestBody BodyTemplate<Divertimento> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Divertimento Modificato");
    }

    @RequestMapping(value = "/eliminaDivertimento", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminaDivertimento(@RequestBody BodyTemplate<Divertimento> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.delete(body.getData().getID(),Divertimento.class);
        return ResponseEntity.ok("Divertimento Eliminato");
    }
}
