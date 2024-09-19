package it.unicam.cs.ItalianWonder.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.ProvinciaService;

@RestController
@RequestMapping(path = "api/v1/provincia")

public class ProvinciaController {
    private final ProvinciaService provinciaService;

    @Autowired
    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }
}
