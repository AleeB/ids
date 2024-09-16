package controllers.POI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.POI.DivertimentoService;

@RestController
@RequestMapping(path = "api/v1/divertimento")

public class DivertimentoController {

    private final DivertimentoService divertimentoService;

    public DivertimentoController(DivertimentoService divertimentoService) {
        this.divertimentoService = divertimentoService;
    }
}
