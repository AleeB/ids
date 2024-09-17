package controllers.users;

import classes.users.Turista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.users.TuristaService;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/turista")
public class TuristaController {

    private final TuristaService turistaService;

    @Autowired
    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
    }

    //login, inviare segnalazione, scrivere recensione(modifica ed eliminazione di essa), votazione contest

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Optional<Turista> getUser(@RequestParam String[] credentials){
        String username = credentials[0];
        String password = credentials[1];
        return turistaService.login(username, password);
    }
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createUser(@RequestParam Turista turista){
        turistaService.addNewTurista(turista);
        return ResponseEntity.ok(true);
    }
}
