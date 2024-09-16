package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.TuristaService;

@RestController
@RequestMapping(path = "api/v1/turista")

public class TuristaController {
    private final TuristaService turistaService;

    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
    }
}
