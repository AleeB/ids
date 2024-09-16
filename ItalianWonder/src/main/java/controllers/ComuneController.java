package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ComuneService;

@RestController
@RequestMapping(path = "api/v1/comune")

public class ComuneController {
    private final ComuneService comuneService;

    public ComuneController(ComuneService comuneService) {
        this.comuneService = comuneService;
    }
}
