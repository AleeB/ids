package services.POI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.POI.DivertimentoRepository;

@Service
public class DivertimentoService {

    private final DivertimentoRepository divertimentoRepository;

    @Autowired
    public DivertimentoService(DivertimentoRepository repository) {
        this.divertimentoRepository = repository;
    }
}
