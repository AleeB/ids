package controllers.media;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.media.VideoService;

@RestController
@RequestMapping(path = "api/v1/video")

public class VideoController {

    private final VideoService videoService;
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }



}
