package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.ArrayList;
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
    public DivertimentoController(Salvare salvareService) {
      this.serviceMediator = salvareService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<List<Divertimento>> getTest() {
        List<Divertimento> tmp = new ArrayList<>();
        Divertimento tmpD = new Divertimento();
        Contributor c = new Contributor();
        tmpD.setContributor(c);
        tmp.add(tmpD);
        return ResponseEntity.ok(tmp);
        /*return ResponseEntity.ok(
            mediator.get().stream()
            .map(item-> (Divertimento)item).toList()
        );*/
    }

    @RequestMapping(value = "/getDivertimenti", method = RequestMethod.POST)
    public ResponseEntity<List<Divertimento>> getAllDivertimenti() {
        return ResponseEntity.ok(
            serviceMediator.get(Divertimento.class).stream()
                .map(item-> (Divertimento)item).toList()
        );
    }

    @RequestMapping(value = "/postDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiDivertimento(@RequestBody BodyTemplate<Divertimento> body) {
        Turista user = (Turista) serviceMediator.get(Map.of("userCredentials", body.getUser()), Turista.class).get(0);
        switch (user.getTipoUser()){
            case Contributor -> body.getData().setApprovazione(false);
            case ContributorAutorizzato,Curatore -> body.getData().setApprovazione(true);
            default -> {
                return ResponseEntity.status(401).body("Non Autorizzato");
            }
        }
        serviceMediator.post(body.getData());
        return ResponseEntity.ok("Divertimento Aggiunto");
    }

    @RequestMapping(value = "/modificaDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> modificaDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        serviceMediator.update(body);
        return ResponseEntity.ok("Divertimento Modificato");
    }

    @RequestMapping(value = "/eliminaDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        serviceMediator.delete(body,Divertimento.class);//Cambiare in ID
        return ResponseEntity.ok("Divertimento Eliminato");
    }
}
