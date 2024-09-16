package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.avereFService;

@RestController
@RequestMapping(path = "api/v1/avereF")

public class avereFController {
    private final avereFService avereFService;

    @Autowired
    public avereFController(services.avereFService avereFService) {
        this.avereFService = avereFService;
    }
}
