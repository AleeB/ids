package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ComuneRepository;

@Service

public class ComuneService {

    private final ComuneRepository comuneRepository;

    @Autowired
    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }

}
