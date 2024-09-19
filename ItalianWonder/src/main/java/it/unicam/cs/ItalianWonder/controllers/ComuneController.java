package it.unicam.cs.ItalianWonder.controllers;

import it.unicam.cs.ItalianWonder.classes.Comune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public ResponseEntity<Optional<Comune>> getAllComuni() {
        Optional<Comune> comuni = comuneService.getAllComuni();
        if(comuni.isPresent()){
            return ResponseEntity.ok(comuni);
        }
        return ResponseEntity.notFound().build();
    }



}
