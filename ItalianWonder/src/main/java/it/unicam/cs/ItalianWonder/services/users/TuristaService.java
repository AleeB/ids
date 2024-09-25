package it.unicam.cs.ItalianWonder.services.users;

import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.TuristaRepository;

import java.util.Optional;

@Service

public class TuristaService {

    private final TuristaRepository turistaRepository;

    @Autowired
    public TuristaService(TuristaRepository turistaRepository) {
        this.turistaRepository = turistaRepository;
    }

    public Optional<Turista> login(String username, String password) {
        return turistaRepository.findByUserNameAndPassword(username, password).stream().findFirst();
    }

    public boolean addNewTurista(Turista turista) {
        if(turista == null){
            return false;
        }
        if(turistaRepository.findByUserName(turista.getUserName()).isPresent()){
            return false;
        }
        turistaRepository.save(turista);
        return true;
    }

    public void save(Turista turista) {
        turistaRepository.save(turista);
    }

    public void delete(Turista user) {
        turistaRepository.delete(user);
    }

    public void updateChanges(Turista user) {
        turistaRepository.saveType(user.getTipoUser().toString(), user.getTipoUser(), user.getUserName());
    }
}
