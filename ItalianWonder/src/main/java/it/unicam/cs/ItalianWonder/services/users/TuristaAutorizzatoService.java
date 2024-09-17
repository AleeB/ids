package it.unicam.cs.ItalianWonder.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.TuristaAutorizzatoRepository;

@Service

public class TuristaAutorizzatoService {

    private final TuristaAutorizzatoRepository turistaAutorizzatoRepository;

    @Autowired
    public TuristaAutorizzatoService(TuristaAutorizzatoRepository turistaAutorizzatoRepository) {
        this.turistaAutorizzatoRepository = turistaAutorizzatoRepository;
    }

}
