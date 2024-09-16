package services.media;

import classes.media.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.media.FotoRepository;

import java.util.Optional;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    @Autowired
    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public void addNewFoto(Foto foto) throws Exception {
        Optional<Foto> optFoto = fotoRepository.findFotoByFoto(foto);

        if (optFoto.isPresent()) {
            throw new Exception("foto already in");
        }

        System.out.println(foto);
    }

    //classe dove andranno inseriti metodi api

}
