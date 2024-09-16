package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.avereVService;

@RestController
@RequestMapping(path = "api/v1/avereV")

public class avereVController {
    private final avereVService avereVService;

    @Autowired
    public avereVController(services.avereVService avereVService) {
        this.avereVService = avereVService;
    }
}
