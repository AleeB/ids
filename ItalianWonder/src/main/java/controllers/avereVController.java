package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.avereVService;

@RestController
@RequestMapping(path = "api/v1/avereV")

public class avereVController {
    private final avereVService avereVService;

    public avereVController(services.avereVService avereVService) {
        this.avereVService = avereVService;
    }
}
