package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.services.POI.DivertimentoService;
import it.unicam.cs.ItalianWonder.services.POI.ItinerarioService;
import it.unicam.cs.ItalianWonder.services.POI.RistoranteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Salvare implements ServiceMediator {
    private final DivertimentoService divertimentoService;
    private final ItinerarioService itinerarioService;
    private final RistoranteService ristoranteService;

    @Autowired
    public Salvare(DivertimentoService divertimentoService,
        ItinerarioService itinerarioService,
        RistoranteService ristoranteService) {
        this.divertimentoService = divertimentoService;
        this.itinerarioService = itinerarioService;
        this.ristoranteService = ristoranteService;
    }

    @Override
    public List<Object> get(Map<String, Object> data) {
        if(data == null) return get();
        return List.of();
    }

    @Override
    public List<Object> get() {
        return List.of();
    }

    @Override
    public void post(Object data) {

    }

    @Override
    public void update(Object data) {

    }

    @Override
    public void delete(Object data) {

    }
}
