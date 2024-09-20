package it.unicam.cs.ItalianWonder.controllers;

import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
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
import it.unicam.cs.ItalianWonder.services.ComuneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/comune")
public class ComuneController {
    private final ComuneService comuneService;

    @Autowired
    public ComuneController(ComuneService comuneService) {
        this.comuneService = comuneService;
    }

    @RequestMapping(value = "/getComuni", method = RequestMethod.POST)
    public ResponseEntity<List<Comune>> getAllComuni() {
        return ResponseEntity.ok(comuneService.getAllComuni());
    }

    @RequestMapping(value = "/postComune", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiComune(@RequestBody Map<String, Map<String, Object>> body) {
        comuneService.aggiungiComune((Comune) body.get("comune").get("comune"),
            (Turista)body.get("utente").get("utente"));
        return ResponseEntity.ok("Comune Aggiunto");
    }

    @RequestMapping(value = "/modificaComune", method = RequestMethod.POST)
    public ResponseEntity<String> modificaComune(@RequestBody Map<String, Map<String, Object>> body) {
        comuneService.modificaComune((Comune) body.get("comune").get("comune"),
            (Turista)body.get("utente").get("utente"));
        return ResponseEntity.ok("Comune Modificato");
    }

    @RequestMapping(value = "/eliminaComune", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaComune(@RequestBody Map<String, Map<String, Object>> body) {
        comuneService.eliminaComune((String) body.get("nomeComune").get("nomeComune"),
            (Turista) body.get("utente"));
        return ResponseEntity.ok("Comune Eliminato");
    }
}
