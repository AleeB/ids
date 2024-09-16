package services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.users.TuristaRepository;

@Service

public class TuristaService {

    private final TuristaRepository turistaRepository;

    @Autowired
    public TuristaService(TuristaRepository turistaRepository) {
        this.turistaRepository = turistaRepository;
    }

}
