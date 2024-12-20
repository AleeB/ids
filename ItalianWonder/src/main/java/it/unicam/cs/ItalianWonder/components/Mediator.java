package it.unicam.cs.ItalianWonder.components;

import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.ComuneService;
import it.unicam.cs.ItalianWonder.services.POI.DivertimentoService;
import it.unicam.cs.ItalianWonder.services.POI.ItinerarioService;
import it.unicam.cs.ItalianWonder.services.POI.PuntoRistoroService;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mediator implements ServiceMediator {
    private final TuristaService turistaService;
    private final DivertimentoService divertimentoService;
    private final ItinerarioService itinerarioService;
    private final PuntoRistoroService puntoRistoroService;
    private final ComuneService comuneService;

    @Autowired
    public Mediator(TuristaService turistaService, DivertimentoService divertimentoService,
                    ItinerarioService itinerarioService,
                    PuntoRistoroService puntoRistoroService, ComuneService comuneService) {
      this.turistaService = turistaService;
      this.divertimentoService = divertimentoService;
        this.itinerarioService = itinerarioService;
        this.puntoRistoroService = puntoRistoroService;
        this.comuneService = comuneService;
    }

    @Override
    public List<?> get(Map<String, Object> data, Class<?> type) {
        if(data == null) return get(type);
        if(data.isEmpty()) return get(type);

        if(type == Turista.class){
            Turista credenziali = (Turista) data.get("userCredentials");
            return turistaService.login(credenziali.getUserName(), credenziali.getPassword()).stream().toList();
        }

        if(type == Itinerario.class && data.containsKey("approvazione")){
            return itinerarioService.getItinerarioByApprovazione(((boolean) data.get("approvazione")));
        }

        if(type == PuntoRistoro.class && data.containsKey("approvazione")){
            return puntoRistoroService.getPuntoRistoroByApprovazione(((boolean) data.get("approvazione")));
        }

        if(type == Divertimento.class && data.containsKey("approvazione")){
            return divertimentoService.getDivertimentoByApprovazione(((boolean) data.get("approvazione")));
        }

        System.err.println(type.toString() + " Get(..) Mediator Not Implemented");
        return List.of();
    }

    @Override
    public List<?> get(Class<?> type) {
        if(type==Divertimento.class) return divertimentoService.getAllDivertimenti();
        if(type== PuntoRistoro.class) return puntoRistoroService.getAllRistoranti();
        if(type== Itinerario.class) return itinerarioService.getAllItinerari();
        if(type== Comune.class) return comuneService.getAllComuni();

        System.err.println(type.toString() + " GET Mediator Not Implemented");
        return List.of();
    }

    @Override
    public void post(Object data) {
        //Utenti
        if(data instanceof Turista tmp) turistaService.save(tmp);
        //POI
        if(data instanceof Divertimento tmp) divertimentoService.aggiungiDivertimento(tmp);
        if(data instanceof PuntoRistoro tmp) puntoRistoroService.aggiungiPuntoRistoro(tmp);
        if(data instanceof Itinerario tmp) itinerarioService.addItinerario(tmp);
        if(data instanceof Comune tmp) comuneService.aggiungiComune(tmp);

        //System.err.println(data.getClass() + " POST Mediator Not Implemented");
    }

    @Override
    public void update(Object data) {
        //Utenti
        if(data instanceof Turista tmp) turistaService.save(tmp);
        //POI
        if(data instanceof Divertimento tmp) divertimentoService.modificaDivertimento(tmp);
        if(data instanceof PuntoRistoro tmp) puntoRistoroService.modificaPuntoRistoro(tmp);
        if(data instanceof Itinerario tmp) itinerarioService.updateItinerario(tmp);
        if(data instanceof Comune tmp) comuneService.modificaComune(tmp);

        //System.err.println(data.getClass() + " UPDATE Mediator Not Implemented");
    }

    @Override
    public void delete(Object data, Class<?> type) {
        //POI
        if(type==Divertimento.class) divertimentoService.eliminaDivertimento((Long) data);
        if(type== PuntoRistoro.class) puntoRistoroService.eliminaPuntoRistoro((Long) data);
        if(type==Itinerario.class) itinerarioService.deleteItinerario(((Long) data));
        if(type==Comune.class) comuneService.eliminaComune((String) data);

        //System.err.println(type.toString() + " DELETE Mediator Not Implemented");
    }
}
