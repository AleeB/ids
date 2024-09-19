package it.unicam.cs.ItalianWonder.services.media;

import it.unicam.cs.ItalianWonder.classes.media.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.media.FotoRepository;

import java.util.Optional;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    @Autowired
    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public boolean addNewFoto(Foto foto) throws Exception {
        Optional<Foto> optFoto = fotoRepository.findByFoto(foto);

        if (optFoto.isPresent()) {
            return false;
        }

        fotoRepository.save(foto);
        return true;
    }


}
