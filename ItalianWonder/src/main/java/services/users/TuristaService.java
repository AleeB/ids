package services.users;

import classes.users.Turista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.users.TuristaRepository;

import java.util.Optional;

@Service

public class TuristaService {

    private final TuristaRepository turistaRepository;

    @Autowired
    public TuristaService(TuristaRepository turistaRepository) {
        this.turistaRepository = turistaRepository;
    }

    public Optional<Turista> login(String username, String password) {
        return turistaRepository.findByUsernameAndPassword().stream().findFirst();
    }

    public boolean addNewTurista(Turista turista) {
        if(turista == null){
            return false;
        }
        turistaRepository.save(turista);
        return true;
    }
}
