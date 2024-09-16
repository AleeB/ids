package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.AnimatoreService;

@RestController
@RequestMapping(path = "api/v1/animatore")

public class AnimatoreController {
    private final AnimatoreService animatoreService;

    public AnimatoreController(AnimatoreService animatoreService) {
        this.animatoreService = animatoreService;
    }
}
