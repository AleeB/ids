package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.CuratoreService;

@RestController
@RequestMapping(path = "api/v1/curatore")

public class CuratoreController {
    private final CuratoreService curatoreService;

    public CuratoreController(CuratoreService curatoreService) {
        this.curatoreService = curatoreService;
    }
}
