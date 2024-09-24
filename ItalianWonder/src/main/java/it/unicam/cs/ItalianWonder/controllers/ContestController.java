package it.unicam.cs.ItalianWonder.controllers;
import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.Contest;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
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
        boolean body = checkUser(contest.getAnimatore().getUserName(), contest.getAnimatore().getPassword());
        if (!body) return ResponseEntity.badRequest().body("Username and password are incorrect or you do not have sufficient privileges");
        contestService.save(contest);
        return ResponseEntity.ok("Contest created");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateContest(@RequestBody BodyTemplate<Contest> body) {
        Contest contest = contestService.findById(body.getData().getId()).orElse(null);
        boolean user = checkUser(body.getUser().getUserName(), body.getUser().getPassword());
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
        boolean check = checkUser(body.getUser().getUserName(), body.getUser().getPassword());
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
        boolean check = checkUser(body.getUser().getUserName(), body.getUser().getPassword());
        if (!check) return ResponseEntity.badRequest().body(null);
        Optional<Contest> c = contestService.findById(body.getData().getId());
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<LocalDateTime> local (){
        return ResponseEntity.ok(LocalDateTime.now());
    }

    //region Private Methods

    private boolean checkUser(String username, String password) {
        Optional<Turista> user = turistaService.login(username, password);
        return user.isPresent() && user.get().getTipoUser() == enumTipoUtente.Animatore;
    }

    //endregion

}
