package it.unicam.cs.ItalianWonder.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.GestoreDellaPiattaformaService;

@RestController
@RequestMapping(path = "api/v1/gestoreDellaPiattaforma")

public class GestoreDellaPiattaformaController {
    private final GestoreDellaPiattaformaService gestoreDellaPiattaformaService;

    @Autowired
    public GestoreDellaPiattaformaController(GestoreDellaPiattaformaService gestoreDellaPiattaformaService) {
        this.gestoreDellaPiattaformaService = gestoreDellaPiattaformaService;
    }
}