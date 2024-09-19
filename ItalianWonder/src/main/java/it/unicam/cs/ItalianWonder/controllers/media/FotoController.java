package it.unicam.cs.ItalianWonder.controllers.media;

import it.unicam.cs.ItalianWonder.classes.media.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> saveFoto(@RequestBody Foto foto) throws Exception {
        if(fotoService.addNewFoto(foto)){
            return ResponseEntity.ok("Foto added");
        }
        return ResponseEntity.badRequest().build();
    }

}
