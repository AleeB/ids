package it.unicam.cs.ItalianWonder.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.AnimatoreService;

@RestController
@RequestMapping(path = "api/v1/animatore")

public class AnimatoreController {
    private final AnimatoreService animatoreService;

    @Autowired
    public AnimatoreController(AnimatoreService animatoreService) {
        this.animatoreService = animatoreService;
    }
}
