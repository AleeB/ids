package controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ProvinciaService;

@RestController
@RequestMapping(path = "api/v1/provincia")

public class ProvinciaController {
    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }
}
