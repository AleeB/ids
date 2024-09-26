package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.POI.RistoranteService;

@RestController
@RequestMapping(path = "api/v1/ristorante")
public class RistoranteController {
    private final ServiceMediator serviceMediator;

    @Autowired
    public RistoranteController(Salvare serviceMediator) {
      this.serviceMediator = serviceMediator;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<Ristorante> test() {
        return ResponseEntity.ok(new Ristorante());
    }

    @RequestMapping(value = "/getRistoranti", method = RequestMethod.POST)
    public ResponseEntity<List<Ristorante>> getAllComuni() {
        return ResponseEntity.ok(serviceMediator.get(Ristorante.class).stream().map(
            item->(Ristorante)item
        ).toList());
    }

    @RequestMapping(value = "/postRistorante", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiRistorante(@RequestBody BodyTemplate<Ristorante> body) {
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
        return ResponseEntity.ok("Ristorante Aggiunto");
    }

    @RequestMapping(value = "/modificaRistorante", method = RequestMethod.POST)
    public ResponseEntity<String> modificaRistorante(@RequestBody BodyTemplate<Ristorante> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Ristorante Modificato");
    }

    @RequestMapping(value = "/eliminaRistorante", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaRistorante(@RequestBody BodyTemplate<Ristorante> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.delete(body.getData().getID(), Ristorante.class);
        return ResponseEntity.ok("Ristorante Eliminato");
    }

    @RequestMapping(value = "/approvaRistorante", method = RequestMethod.POST)
    public ResponseEntity<String> approvaDivertimento(@RequestBody BodyTemplate<Ristorante> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if (user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");

        body.getData().setApprovazione(true);
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Ristorante Approvato! (Buon pranzo :) )");
    }
}
