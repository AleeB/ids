package it.unicam.cs.ItalianWonder.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.UserNonAutenticatoService;

@RestController
@RequestMapping(path = "api/v1/userNA")
public class UserNonAutenticatoController {
    private final UserNonAutenticatoService userNonAutenticatoService;

    @Autowired
    public UserNonAutenticatoController(UserNonAutenticatoService userNonAutenticatoService) {
        this.userNonAutenticatoService = userNonAutenticatoService;
    }


}
