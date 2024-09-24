package it.unicam.cs.ItalianWonder.controllers;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comune")
public class ComuneController {
    private final ServiceMediator serviceMediator;

    @Autowired
    public ComuneController(Salvare mediator) {
      this.serviceMediator = mediator;
    }

    @RequestMapping(value = "/getComuni", method = RequestMethod.POST)
    public ResponseEntity<List<Comune>> getAllComuni() {
        return ResponseEntity.ok(serviceMediator.get(Comune.class).stream().map(
            item->(Comune)item
        ).toList());
    }

    @RequestMapping(value = "/postComune", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiComune(@RequestBody BodyTemplate<Comune> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.post(body.getData());
        return ResponseEntity.ok("Comune Aggiunto");
    }

    @RequestMapping(value = "/modificaComune", method = RequestMethod.POST)
    public ResponseEntity<String> modificaComune(@RequestBody BodyTemplate<Comune> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.update(body.getData());
        return ResponseEntity.ok("Comune Modificato");
    }

    @RequestMapping(value = "/eliminaComune", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaComune(@RequestBody BodyTemplate<Comune> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        if(user.getTipoUser() != enumTipoUtente.Curatore)
            return ResponseEntity.status(401).body("Non Autorizzato");
        serviceMediator.delete(body.getData().getNome(), Comune.class);
        return ResponseEntity.ok("Comune Eliminato");
    }
}
