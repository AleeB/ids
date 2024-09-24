package it.unicam.cs.ItalianWonder.controllers.users;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.*;
import it.unicam.cs.ItalianWonder.services.users.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/turista")
public class TuristaController {

    private final TuristaService turistaService;
    private final TuristaAutorizzatoService turistaAutorizzatoService;
    private final ContributorService contributorService;
    private final ContributorAutorizzatoService contributorAutorizzatoService;
    private final AnimatoreService animatoreService;
    private final CuratoreService curatoreService;
    private final GestoreDellaPiattaformaService gestoreDellaPiattaformaService;

    @Autowired
    public TuristaController(TuristaService turistaService, TuristaAutorizzatoService turistaAutorizzatoService, ContributorService contributorService, ContributorAutorizzatoService contributorAutorizzatoService, AnimatoreService animatoreService, CuratoreService curatoreService, GestoreDellaPiattaformaService gestoreDellaPiattaformaService) {
        this.turistaService = turistaService;
        this.turistaAutorizzatoService = turistaAutorizzatoService;
        this.contributorService = contributorService;
        this.contributorAutorizzatoService = contributorAutorizzatoService;
        this.animatoreService = animatoreService;
        this.curatoreService = curatoreService;
        this.gestoreDellaPiattaformaService = gestoreDellaPiattaformaService;
    }

    //login, inviare segnalazione, scrivere recensione(modifica ed eliminazione di essa), votazione contest

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Optional<Turista>> getUser(@RequestBody Map<String, Object> body){
        String username = body.get("userName").toString();
        String password = String.valueOf(body.get("password").hashCode());
        Optional<Turista> tur = turistaService.login(username, password);
        if(tur.isEmpty()){
            return ResponseEntity.badRequest().body(tur);
        }
        return ResponseEntity.ok().body(tur);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody Turista turista){
        turista.setPassword(Integer.toString(turista.getPassword().hashCode()));
        turista.setTipoUser(enumTipoUtente.Turista);
        turista.setPunteggio(0);
        if(turistaService.addNewTurista(turista)){
            return ResponseEntity.ok("Turista added");
        }
        return ResponseEntity.badRequest().body("Turista not added");
    }

    @RequestMapping(value = "/changeTypeUser", method = RequestMethod.POST)
    public ResponseEntity<String> changeTypeOfUser(@RequestBody BodyTemplate<enumTipoUtente> body){
        Turista user = new Turista();
        enumTipoUtente tipoUtente = enumTipoUtente.valueOf(body.getData().name());
        user = turistaService.login(body.getUser().getUserName(), body.getUser().getPassword()).get();
        turistaService.delete(user);
        user.setTipoUser(tipoUtente);
        return switch (tipoUtente){
            case Turista:
                turistaService.save(user);
                yield ResponseEntity.ok("Turista saved");
            case TuristaAutorizzato:
                turistaAutorizzatoService.save(new TuristaAutorizzato(user));
                yield ResponseEntity.ok("Turista Autorizzato saved");
            case Contributor:
                contributorService.save(new Contributor(user));
                yield ResponseEntity.ok("Contributor saved");
            case ContributorAutorizzato:
                contributorAutorizzatoService.save(new ContributorAutorizzato(user));
                yield ResponseEntity.ok("Contributor Autorizzato saved");
            case Animatore:
                animatoreService.save(new Animatore(user));
                yield ResponseEntity.ok("Animatore saved");
            case Curatore:
                curatoreService.save(new Curatore(user));
                yield ResponseEntity.ok("Curatore saved");
            case GestoreDellaPiattaforma:
                gestoreDellaPiattaformaService.save(new GestoreDellaPiattaforma(user));
                yield ResponseEntity.ok("Gestore Della Piattaforma saved");
            default:
                yield ResponseEntity.badRequest().body("invalid user's type");
        };

    }

}
