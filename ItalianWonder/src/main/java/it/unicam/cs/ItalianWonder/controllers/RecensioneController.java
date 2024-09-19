package it.unicam.cs.ItalianWonder.controllers;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.RecensioneService;

import java.util.Map;
import java.util.Objects;
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
    @RequestMapping(value = "/newRecensione", method = RequestMethod.POST)
    public ResponseEntity<String> addNewRecensione(@RequestBody Recensione recensione) {
        if(turistaService.login(recensione.getTurista().getUserName(), recensione.getTurista().getPassword()).isEmpty()){
            return ResponseEntity.badRequest().body("couldn't find user");
        }
        recensioneService.addNewRecensione(recensione);
        return ResponseEntity.ok("Recensione added");
    }

    @RequestMapping(value = "/deleteRecensione", method = RequestMethod.POST)
    public ResponseEntity<String> deleteRecensione(@RequestBody Map<String, Map<String, Object>> map) {
        Recensione recensione = new Recensione();
        recensione.setID(((Long) map.get("recensione").get("id")));
        Turista turista = mapValueTurista(map.get("currentTurista"));
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

    @RequestMapping(value = "/getRecensione", method = RequestMethod.POST)
    public ResponseEntity<Recensione> getRecensioneById(@RequestBody Map<String, Object> id) {
        Long recensione_id =  Long.valueOf(id.get("id").toString());
        Optional<Recensione> rec = recensioneService.getRecensioneByID(recensione_id);
        if(rec.isPresent()){
            return ResponseEntity.ok().body(rec.get());
        }
        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "/getRecensioniPOI", method = RequestMethod.POST)
    public ResponseEntity<Optional<Recensione>> getRecensioneByPOI(@RequestBody Object POI){
        if (POI instanceof Divertimento) {
            Optional<Recensione> rec = recensioneService.getRecensioneByDivertimento(((Divertimento) POI));
            if(rec.isPresent()){
                return ResponseEntity.ok(rec);
            }
            return ResponseEntity.badRequest().body(Optional.empty());
        } else if (POI instanceof Itinerario) {
            Optional<Recensione> rec = recensioneService.getRecensioneByItinerario(((Itinerario) POI));
            if(rec.isPresent()){
                return ResponseEntity.ok(rec);
            }
            return ResponseEntity.badRequest().body(Optional.empty());
        } else if (POI instanceof Ristorante) {
            Optional<Recensione> rec = recensioneService.getRecensioneByRistorante(((Ristorante) POI));
            if(rec.isPresent()){
                return ResponseEntity.ok(rec);
            }
            return ResponseEntity.badRequest().body(Optional.empty());
        }
        return ResponseEntity.badRequest().body(Optional.empty());
    }

    //da modificare per aggiunta FK POI
    @RequestMapping(value = "/updateRecensione", method = RequestMethod.POST)
    public ResponseEntity<String> updateRecensione(@RequestBody Map<String, Map<String, Object>> map){
        Recensione recensione = mapValueRecensione(map.get("recensione"));
        Turista turista = mapValueTurista(map.get("currentTurista"));
        return switch (recensione.getTurista().getTipoUser()) {
            case Turista, TuristaAutorizzato -> {
                if (recensione.getTurista().equals(turista)) {
                    if (recensioneService.updateRecensione(recensione)) {
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

    private Turista mapValueTurista(Map<String,Object> map) {
       return turistaService.login(map.get("userName").toString(), map.get("password").toString()).get();
    }

    private Recensione mapValueRecensione(Map<String,Object> recensione) {
        Recensione rec = new Recensione();
        rec.setID(Long.parseLong(recensione.get("id").toString()));
        rec.setDescrizione(recensione.get("descrizione").toString());
        rec.setTurista(mapValueTurista((Map) recensione.get("turista")));
        rec.setValutazione(((int) recensione.get("valutazione")));
        rec.setVerificata(((Boolean) recensione.get("verificata")));
        return rec;
    }



}
