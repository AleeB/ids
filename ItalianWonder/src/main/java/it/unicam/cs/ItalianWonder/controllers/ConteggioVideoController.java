package it.unicam.cs.ItalianWonder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.ConteggioVideoService;

@RestController
@RequestMapping(path = "api/v1/avereV")

public class ConteggioVideoController {
    private final ConteggioVideoService ConteggioVideoService;

    @Autowired
    public ConteggioVideoController(ConteggioVideoService ConteggioVideoService) {
        this.ConteggioVideoService = ConteggioVideoService;
    }
}
