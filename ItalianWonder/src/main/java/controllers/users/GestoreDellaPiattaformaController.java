package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.GestoreDellaPiattaformaService;

@RestController
@RequestMapping(path = "api/v1/gestoreDellaPiattaforma")

public class GestoreDellaPiattaformaController {
    private final GestoreDellaPiattaformaService gestoreDellaPiattaformaService;

    public GestoreDellaPiattaformaController(GestoreDellaPiattaformaService gestoreDellaPiattaformaService) {
        this.gestoreDellaPiattaformaService = gestoreDellaPiattaformaService;
    }
}
