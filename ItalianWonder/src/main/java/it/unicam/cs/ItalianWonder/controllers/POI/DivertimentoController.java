package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.POI.DivertimentoService;

@RestController
@RequestMapping(path = "api/v1/divertimento")
public class DivertimentoController {

    private final DivertimentoService divertimentoService;

    public DivertimentoController(DivertimentoService divertimentoService) {
        this.divertimentoService = divertimentoService;
    }

    @RequestMapping(value = "/getDivertimenti", method = RequestMethod.POST)
    public ResponseEntity<List<Divertimento>> getAllDivertimenti() {
        return ResponseEntity.ok(divertimentoService.getAllDivertimenti());
    }

    @RequestMapping(value = "/postDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> aggiungiDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        divertimentoService.aggiungiDivertimento((Divertimento) body.get("divertimento").get("divertimento"),
            (Turista)body.get("utente").get("utente"));
        return ResponseEntity.ok("Divertimento Aggiunto");
    }

    @RequestMapping(value = "/modificaDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> modificaDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        divertimentoService.modificaDivertimento((Divertimento) body.get("comune").get("comune"),
            (Turista)body.get("utente").get("utente"));
        return ResponseEntity.ok("Divertimento Modificato");
    }

    @RequestMapping(value = "/eliminaDivertimento", method = RequestMethod.POST)
    public ResponseEntity<String> eliminaDivertimento(@RequestBody Map<String, Map<String, Object>> body) {
        divertimentoService.eliminaDivertimento((Long) body.get("divertimentoID").get("divertimentoID"),
            (Turista) body.get("utente"));
        return ResponseEntity.ok("Divertimento Eliminato");
    }
}
