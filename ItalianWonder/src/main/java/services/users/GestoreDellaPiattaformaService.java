package services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.users.GestoreDellaPiattaformaRepository;

@Service
public class GestoreDellaPiattaformaService {

    private final GestoreDellaPiattaformaRepository repository;

    @Autowired
    public GestoreDellaPiattaformaService(GestoreDellaPiattaformaRepository repository) {
        this.repository = repository;
    }

}
