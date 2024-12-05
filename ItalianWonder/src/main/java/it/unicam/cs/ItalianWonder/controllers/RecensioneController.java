package it.unicam.cs.ItalianWonder.controllers;
import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.ItalianWonder.services.RecensioneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/recensione")

public class RecensioneController {
    private final RecensioneService recensioneService;
    private final TuristaService turistaService;

    @Autowired
    public RecensioneController(RecensioneService recensioneService, TuristaService turistaService) {
        this.recensioneService = recensioneService;
        this.turistaService = turistaService;
    }

    //da modificare per FK sui POI
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addNewRecensione(@RequestBody Recensione recensione) {
        if(turistaService.login(recensione.getTurista().getUserName(), recensione.getTurista().getPassword()).isEmpty()){
            return ResponseEntity.badRequest().body("couldn't find user");
        }
        recensioneService.addNewRecensione(recensione);
        return ResponseEntity.ok("Recensione added");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRecensione(@RequestBody BodyTemplate<Recensione> body) {
        Recensione recensione = body.getData();
        recensione.setTurista(getTurista(recensione.getTurista().getUserName(), recensione.getTurista().getPassword()));
        Turista turista = getTurista(body.getUser().getUserName(), body.getUser().getPassword());
        return switch (((recensione.getTurista().getTipoUser()))) {
            case Turista, TuristaAutorizzato -> {
                if (recensione.getTurista() == turista) {
                    if(recensioneService.deleteRecensione(recensione.getID())){
                        yield ResponseEntity.ok("Recensione deleted");
                    }else{
                        yield ResponseEntity.badRequest().build();
                    }
                }
                yield ResponseEntity.badRequest().body("permission denied");
            }
            case Contributor, ContributorAutorizzato, Animatore, Curatore, GestoreDellaPiattaforma -> {
                if(recensioneService.deleteRecensione(recensione.getID())){
                    yield ResponseEntity.ok("Recensione deleted");
                }else{
                    yield ResponseEntity.badRequest().body("permission denied");
                }
            }
            default -> ResponseEntity.badRequest().body("invalid type of user");
        };
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recensione> getRecensioneById(@PathVariable Long id) {
        Optional<Recensione> rec = recensioneService.getRecensioneByID(id);
        return rec.map(recensione -> ResponseEntity.ok().body(recensione)).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @RequestMapping(value = "/getRecensioniPOI", method = RequestMethod.POST)
    public ResponseEntity<Optional<List<Recensione>>> getRecensioneByPOI(@RequestBody Object POI){
        if (POI instanceof Divertimento) {
            Optional<List<Recensione>> rec = recensioneService.getRecensioneByDivertimento(((Divertimento) POI));
            if(rec.isPresent()){
                return ResponseEntity.ok(rec);
            }
            return ResponseEntity.badRequest().body(Optional.empty());
        } else if (POI instanceof Itinerario) {
            Optional<List<Recensione>> rec = recensioneService.getRecensioneByItinerario(((Itinerario) POI));
            if(rec.isPresent()){
                return ResponseEntity.ok(rec);
            }
            return ResponseEntity.badRequest().body(Optional.empty());
        } else if (POI instanceof PuntoRistoro) {
            Optional<List<Recensione>> rec = recensioneService.getRecensioneByPuntoRistoro(((PuntoRistoro) POI));
            if(rec.isPresent()){
                return ResponseEntity.ok(rec);
            }
            return ResponseEntity.badRequest().body(Optional.empty());
        }
        return ResponseEntity.badRequest().body(Optional.empty());
    }

    //da modificare per aggiunta FK POI
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRecensione(@RequestBody BodyTemplate<Recensione> body){
        Turista turista = getTurista(body.getUser().getUserName(), body.getUser().getPassword());
        body.getData().setTurista(getTurista(body.getUser().getUserName(), body.getUser().getPassword()));
        return switch (body.getData().getTurista().getTipoUser()) {
            case Turista, TuristaAutorizzato -> {
                if (body.getData().getTurista().equals(turista)) {
                    if (recensioneService.updateRecensione(body.getData())) {
                        yield ResponseEntity.ok("Recensione updated");
                    } else {
                        yield ResponseEntity.badRequest().build();
                    }
                }
                yield ResponseEntity.badRequest().body("permission denied");
            }
            default -> ResponseEntity.badRequest().body("invalid type of user");
        };
    }

    private Turista getTurista(String userName, String password) {
       return turistaService.login(userName, password).get();
    }


}
