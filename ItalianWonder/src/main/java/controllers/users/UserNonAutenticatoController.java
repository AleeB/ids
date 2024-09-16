package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.UserNonAutenticatoService;

@RestController
@RequestMapping(path = "api/v1/userNonAutenticato")

public class UserNonAutenticatoController {
    private final UserNonAutenticatoService userNonAutenticatoService;

    public UserNonAutenticatoController(UserNonAutenticatoService userNonAutenticatoService) {
        this.userNonAutenticatoService = userNonAutenticatoService;
    }
}
