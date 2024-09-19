package it.unicam.cs.ItalianWonder.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.UserNonAutenticatoRepository;

@Service

public class UserNonAutenticatoService {

    private final UserNonAutenticatoRepository userNonAutenticatoRepository;

    @Autowired
    public UserNonAutenticatoService(UserNonAutenticatoRepository unaRepository) {
        this.userNonAutenticatoRepository = unaRepository;
    }

}
