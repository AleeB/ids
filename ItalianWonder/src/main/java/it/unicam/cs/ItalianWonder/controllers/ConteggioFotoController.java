package it.unicam.cs.ItalianWonder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.ConteggioFotoService;

@RestController
@RequestMapping(path = "api/v1/avereF")

public class ConteggioFotoController {
    private final ConteggioFotoService ConteggioFotoService;

    @Autowired
    public ConteggioFotoController(ConteggioFotoService ConteggioFotoService) {
        this.ConteggioFotoService = ConteggioFotoService;
    }
}
