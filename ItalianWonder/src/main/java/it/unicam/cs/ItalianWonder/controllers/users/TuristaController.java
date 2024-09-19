package it.unicam.cs.ItalianWonder.controllers.users;

import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;

import java.util.Map;
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
    public ResponseEntity<Optional<Turista>> getUser(@RequestBody Map<String, Object> body){
        String username = body.get("userName").toString();
        String password = Integer.toString(body.get("password").hashCode());
        Optional<Turista> tur = turistaService.login(username, password);
        if(tur.isEmpty()){
            return ResponseEntity.badRequest().body(tur);
        }
        return ResponseEntity.ok().body(tur);
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody Turista turista){
        turista.setPassword(Integer.toString(turista.getPassword().hashCode()));
        turista.setTipoUser(enumTipoUtente.Turista);
        if(turistaService.addNewTurista(turista)){
            return ResponseEntity.ok("Turista added");
        }
        return ResponseEntity.badRequest().body("Turista not added");
    }


}
