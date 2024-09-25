package it.unicam.cs.ItalianWonder.controllers;
import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.Contest;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Animatore;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.ItalianWonder.services.ContestService;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/contest")

public class ContestController {
    private final ContestService contestService;
    private final TuristaService turistaService;

    @Autowired
    public ContestController(ContestService contestService, TuristaService turistaService) {
        this.contestService = contestService;
        this.turistaService = turistaService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addNewContest(@RequestBody Contest contest) {
        Turista tur = getUser(contest.getAnimatore().getUserName(), contest.getAnimatore().getPassword());
        if (!checkUser(tur)) return ResponseEntity.badRequest().body("Username and password are incorrect or you do not have sufficient privileges");
        contest.setAnimatore(new Animatore(tur));
        contestService.save(contest);
        return ResponseEntity.ok("Contest created");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateContest(@RequestBody BodyTemplate<Contest> body) {
        Contest contest = contestService.findById(body.getData().getId()).orElse(null);
        boolean user = checkUser(getUser(body.getUser().getUserName(), body.getUser().getPassword()));
        if (!user) return ResponseEntity.badRequest().body("Username and password are incorrect or you do not have sufficient privileges");
        if(contest == null){
            return ResponseEntity.notFound().build();
        }
        contest = body.getData();
        contestService.save(contest);
        return ResponseEntity.ok().body("Contest updated");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteContest(@RequestBody BodyTemplate<Contest> body) {
        boolean check = checkUser(getUser(body.getUser().getUserName(), body.getUser().getPassword()));
        if (!check) return ResponseEntity.badRequest().body("Username and password are incorrect or you do not have sufficient privileges");
        Contest findC = contestService.findById(body.getData().getId()).orElse(null);
        if(findC == null){
            return ResponseEntity.notFound().build();
        }
        contestService.delete(findC);
        return ResponseEntity.ok("Contest deleted");
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResponseEntity<Contest> getContestById(@RequestBody BodyTemplate<Contest> body) {
        boolean check = checkUser(getUser(body.getUser().getUserName(), body.getUser().getPassword()));
        if (!check) return ResponseEntity.badRequest().body(null);
        Optional<Contest> c = contestService.findById(body.getData().getId());
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //region Private Methods

    private Turista getUser(String username, String password) {
        return turistaService.login(username, password).orElse(null);
    }

    private boolean checkUser(Turista user) {
        return user != null && user.getTipoUser() == enumTipoUtente.Animatore;
    }

    //endregion

}
