package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.services.POI.DivertimentoService;
import it.unicam.cs.ItalianWonder.services.POI.ItinerarioService;
import it.unicam.cs.ItalianWonder.services.POI.RistoranteService;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Salvare implements ServiceMediator {
    private final TuristaService turistaService;
    private final DivertimentoService divertimentoService;
    private final ItinerarioService itinerarioService;
    private final RistoranteService ristoranteService;

    @Autowired
    public Salvare(TuristaService turistaService, DivertimentoService divertimentoService,
        ItinerarioService itinerarioService,
        RistoranteService ristoranteService) {
      this.turistaService = turistaService;
      this.divertimentoService = divertimentoService;
        this.itinerarioService = itinerarioService;
        this.ristoranteService = ristoranteService;
    }

    @Override
    public List<Object> get(Map<String, Object> data, Class<?> type) {
        if(data == null) return get(type);
        if(data.isEmpty()) return get(type);

        if(type == Turista.class){
            Turista credenziali = (Turista) data.get("userCredentials");
            return Collections.singletonList(
                turistaService.login(credenziali.getUserName(), credenziali.getPassword()));
        }

        return List.of();
    }

    @Override
    public List<Object> get(Class<?> type) {
        if(type==Divertimento.class) return Collections.singletonList(
            divertimentoService.getAllDivertimenti());

        return List.of();
    }

    @Override
    public void post(Object data) {
        if(data instanceof Divertimento) divertimentoService.aggiungiDivertimento((Divertimento) data);
    }

    @Override
    public void update(Object data) {

    }

    @Override
    public void delete(Object data, Class<?> type) {

    }
}
