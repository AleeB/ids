package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.ContributorService;

@RestController
@RequestMapping(path = "api/v1/contributor")
public class ContributorController {
    private final ContributorService contributorService;

    public ContributorController(ContributorService contributorService) {
        this.contributorService = contributorService;
    }
}
