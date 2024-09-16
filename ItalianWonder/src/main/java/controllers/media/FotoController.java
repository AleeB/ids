package controllers.media;

import classes.media.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import services.media.FotoService;

@RestController
@RequestMapping(path = "api/v1/foto")
public class FotoController {

    private final FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

}
