package it.unicam.cs.ItalianWonder.controllers;

import it.unicam.cs.ItalianWonder.classes.BodyTemplate;
import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoSegnalazione;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.SegnalazioneService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/segnalazione")
public class SegnalazioneController {
    private final SegnalazioneService segnalazioneService;
    private final TuristaService turistaService;

    @Autowired
    public SegnalazioneController(SegnalazioneService segnalazioneService, TuristaService turistaService) {
        this.segnalazioneService = segnalazioneService;
        this.turistaService = turistaService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addSegnalazione(@RequestBody Segnalazione segnalazione) {
        if(turistaService.login(segnalazione.getTurista().getUserName(), segnalazione.getTurista().getPassword()).isEmpty()){
            return ResponseEntity.badRequest().body("couldn't find user");
        }
        segnalazioneService.addNewSegnalazione(segnalazione);
        return ResponseEntity.ok("Segnalazione added");
    }

    @RequestMapping(value = "/getSegnalazioniByTipo", method = RequestMethod.GET)
    public ResponseEntity<List<Segnalazione>> getAllSegnalazione(@RequestBody Turista turista) {
        Turista user = new Turista();
        try {
            user = turistaService.login(turista.getUserName(), turista.getPassword()).get();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
        return switch(user.getTipoUser()){
            case Contributor:
                yield ResponseEntity.ok().body(segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.recensione));
            case ContributorAutorizzato:
                List<Segnalazione> segnalazioniMedia = segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.foto);
                segnalazioniMedia.addAll(segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.video));
                yield ResponseEntity.ok().body(segnalazioniMedia);
            case Curatore:
                List<Segnalazione> segnalazioniPOI = segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.foto);
                segnalazioniPOI.addAll(segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.divertimento));
                segnalazioniPOI.addAll(segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.itinerario));
                segnalazioniPOI.addAll(segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.PuntoRistoro));
                yield ResponseEntity.ok().body(segnalazioniPOI);
            case GestoreDellaPiattaforma:
                yield ResponseEntity.ok().body(segnalazioneService.getSegnalazioneByTipo(enumTipoSegnalazione.bug));
            default:
                yield ResponseEntity.badRequest().body(null);
        };
    }

    @RequestMapping(value = "/approva", method = RequestMethod.POST)
    public ResponseEntity<String> approveSegnalazione(@RequestBody BodyTemplate<Segnalazione> body){
        Segnalazione segnalazione = segnalazioneService.getSegnalazioneById(body.getData().getID()).orElse(null);
        if(segnalazione == null){
            return ResponseEntity.badRequest().body("segnalazione does not exist");
        }
        Turista tur = turistaService.login(body.getUser().getUserName(), body.getUser().getPassword()).orElse(null);
        if (tur == null) {
            return ResponseEntity.badRequest().body("couldn't find user");
        }
        return switch(tur.getTipoUser()){
            case Contributor:
                if(segnalazione.getTipo().equals(enumTipoSegnalazione.recensione)){
                    segnalazioneService.delete(body.getData().getID());
                    yield ResponseEntity.ok().body("Segnalazione deleted");
                }
                yield ResponseEntity.badRequest().body("this user does not have sufficient permissions");
            case ContributorAutorizzato:
                if(segnalazione.getTipo().equals(enumTipoSegnalazione.foto) || segnalazione.getTipo().equals(enumTipoSegnalazione.video)){
                    segnalazioneService.delete(body.getData().getID());
                    yield ResponseEntity.ok().body("Segnalazione deleted");
                }
                yield ResponseEntity.badRequest().body("this user does not have sufficient permissions");
            case Curatore:
                if(segnalazione.getTipo().equals(enumTipoSegnalazione.divertimento) || segnalazione.getTipo().equals(enumTipoSegnalazione.itinerario) || segnalazione.getTipo().equals(enumTipoSegnalazione.PuntoRistoro)){
                    segnalazioneService.delete(body.getData().getID());
                    yield ResponseEntity.ok().body("Segnalazione deleted");
                }
                yield ResponseEntity.badRequest().body("this user does not have sufficient permissions");
            case GestoreDellaPiattaforma:
                if(segnalazione.getTipo().equals(enumTipoSegnalazione.bug)){
                    segnalazioneService.delete(body.getData().getID());
                    yield ResponseEntity.ok().body("Segnalazione deleted");
                }
                yield ResponseEntity.badRequest().body("this user does not have sufficient permissions");
            default:
                yield ResponseEntity.badRequest().body("this user does not have sufficient permissions");
        };

    }

}