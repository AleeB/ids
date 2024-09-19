package it.unicam.cs.ItalianWonder.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.CuratoreRepository;

@Service

public class CuratoreService {

    private final CuratoreRepository curatoreRepository;

    @Autowired
    public CuratoreService(CuratoreRepository curatoreRepository) {
        this.curatoreRepository = curatoreRepository;
    }

}
