package it.unicam.cs.ItalianWonder.controllers.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
