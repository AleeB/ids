package it.unicam.cs.ItalianWonder.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.ContributorService;

@RestController
@RequestMapping(path = "api/v1/contributor")
public class ContributorController {
    private final ContributorService contributorService;

    @Autowired
    public ContributorController(ContributorService contributorService) {
        this.contributorService = contributorService;
    }
}
