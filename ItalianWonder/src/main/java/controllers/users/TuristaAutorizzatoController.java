package controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.TuristaAutorizzatoService;

@RestController
@RequestMapping(path = "api/v1/turistaAutorizzato")

public class TuristaAutorizzatoController {
    private final TuristaAutorizzatoService turistaAutorizzatoService;

    @Autowired
    public TuristaAutorizzatoController(TuristaAutorizzatoService turistaAutorizzatoService) {
        this.turistaAutorizzatoService = turistaAutorizzatoService;
    }
}
