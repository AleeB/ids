package it.unicam.cs.ItalianWonder.controllers.media;

import it.unicam.cs.ItalianWonder.classes.media.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.ItalianWonder.services.media.FotoService;

@RestController
@RequestMapping(path = "api/v1/foto")
public class FotoController {

    private final FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }


    //esempio
    @PostMapping
    public void saveFoto(@RequestBody Foto foto) throws Exception {
        fotoService.addNewFoto(foto);
    }

}
