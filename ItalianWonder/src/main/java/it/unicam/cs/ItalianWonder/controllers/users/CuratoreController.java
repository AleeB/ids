package it.unicam.cs.ItalianWonder.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.CuratoreService;

@RestController
@RequestMapping(path = "api/v1/curatore")

public class CuratoreController {
    private final CuratoreService curatoreService;

    @Autowired
    public CuratoreController(CuratoreService curatoreService) {
        this.curatoreService = curatoreService;
    }
}
