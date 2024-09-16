package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RecensioneRepository;

@Service

public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    @Autowired
    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;
    }

}
