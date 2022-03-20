package se.firmacarboo.letsgo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.repository.ImageRepository;
import se.firmacarboo.letsgo.service.ImageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/images")
@AllArgsConstructor
public class ImageController {
    ImageService imageService;

    @GetMapping
    public List<Image> getAllImages(){
        return imageService.getAllImages();
    }

    @GetMapping("/{imageId}")
    public Optional<Image> getImage(@PathVariable String imageId){
        // TODO Returns null now if no Image found.
        return imageService.getImageById(imageId);
    }

    @PostMapping("/register-image")
    public ResponseEntity<String> registerNewImage(@RequestBody Image image){
//        Handle thrown exception for duplicate key on imageURL
        return new ResponseEntity(imageService.registerNewImage(image), HttpStatus.OK);
    }


}
