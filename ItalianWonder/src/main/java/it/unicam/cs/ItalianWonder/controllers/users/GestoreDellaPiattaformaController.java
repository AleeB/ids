package it.unicam.cs.ItalianWonder.controllers.users;

import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.GestoreDellaPiattaformaService;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/gestoreDellaPiattaforma")

public class GestoreDellaPiattaformaController {
    private final GestoreDellaPiattaformaService gestoreDellaPiattaformaService;

    @Autowired
    public GestoreDellaPiattaformaController(GestoreDellaPiattaformaService gestoreDellaPiattaformaService, TuristaService turistaService) {
        this.gestoreDellaPiattaformaService = gestoreDellaPiattaformaService;
    }

}
