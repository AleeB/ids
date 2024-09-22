package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/divertimento")
public class DivertimentoController {

    private final ServiceMediator mediator;

    @Autowired
    public DivertimentoController(Salvare salvareService) {
      this.mediator = salvareService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<List<Divertimento>> getTest() {
        /*List<Divertimento> tmp = new ArrayList<>();
        Divertimento tmpD = new Divertimento();
        Contributor c = new Contributor();
        tmpD.setContributor(c);
        tmp.add(tmpD);*/
        return ResponseEntity.ok(
            mediator.get().stream()
            .map(item-> (Divertimento)item).toList()
        );
    }

    @RequestMapping(value = "/getDivertimenti", method = RequestMethod.POST)
    public ResponseEntity<List<Divertimento>> getAllDivertimenti() {
        return ResponseEntity.ok(
            mediator.get(null).stream()
                .map(item-> (Divertimento)item).toList()
        );
    }

    @RequestMapping(value = "/postDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiDivertimento(@RequestBody Map<String, Object> body) {
        if(!body.containsKey("user")) return ResponseEntity.status(401).body("Accesso non autorizzato");
        Map<String, Object> user = (Map<String, Object>) body.get("user");
        if()
        mediator.post(body);
        return ResponseEntity.ok("Divertimento Aggiunto");
    }

    @RequestMapping(value = "/modificaDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> modificaDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        mediator.update(body);
        return ResponseEntity.ok("Divertimento Modificato");
    }

    @RequestMapping(value = "/eliminaDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        mediator.delete(body);//Cambiare in ID
        return ResponseEntity.ok("Divertimento Eliminato");
    }
}
