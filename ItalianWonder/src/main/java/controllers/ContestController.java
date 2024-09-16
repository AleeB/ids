package controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ContestService;

@RestController
@RequestMapping(path = "api/v1/contest")

public class ContestController {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }
}
