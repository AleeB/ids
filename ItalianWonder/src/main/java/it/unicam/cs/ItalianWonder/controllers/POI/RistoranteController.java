package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
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
    private final RistoranteService ristoranteService;

    @Autowired
    public RistoranteController(RistoranteService ristoranteService) {
        this.ristoranteService = ristoranteService;
    }

    @RequestMapping(value = "/getRistoranti", method = RequestMethod.POST)
    public ResponseEntity<List<Ristorante>> getAllComuni() {
        return ResponseEntity.ok(ristoranteService.getAllRistoranti());
    }

    @RequestMapping(value = "/postComune", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiRistorante(@RequestBody Map<String, Map<String, Object>> body) {
        ristoranteService.aggiungiRistorante((Ristorante) body.get("ristorante").get("ristorante"),
            (Turista)body.get("utente").get("utente"));
        return ResponseEntity.ok("Ristorante Aggiunto");
    }

    @RequestMapping(value = "/modificaComune", method = RequestMethod.POST)
    public ResponseEntity<String> modificaRistorante(@RequestBody Map<String, Map<String, Object>> body) {
        ristoranteService.modificaRistorante((Ristorante) body.get("ristorante").get("ristorante"),
            (Turista)body.get("utente").get("utente"));
        return ResponseEntity.ok("Ristorante Modificato");
    }

    @RequestMapping(value = "/eliminaRistorante", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaRistorante(@RequestBody Map<String, Map<String, Object>> body) {
        ristoranteService.eliminaRistorante((Long) body.get("nomeComune").get("nomeComune"),
            (Turista) body.get("utente"));
        return ResponseEntity.ok("Ristorante Eliminato");
    }
}
