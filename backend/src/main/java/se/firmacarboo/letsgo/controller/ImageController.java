package se.firmacarboo.letsgo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.service.ImageServiceImpl;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("api/v1/images")
@AllArgsConstructor
public class ImageController {
    ImageServiceImpl imageServiceImpl;

    @GetMapping
    public List<Image> getAllImages(){
        return imageServiceImpl.getAllImages();
    }

    @GetMapping("/{imageId}")
    public Optional<Image> getImage(@PathVariable String imageId){
        // TODO Returns null now if no Image found.
        return imageServiceImpl.getImageById(imageId);
    }

    @PostMapping("/register-image")
    public ResponseEntity<String> registerNewImage(@RequestBody Image image){
        return new ResponseEntity(imageServiceImpl.registerNewImage(image), HttpStatus.OK);
    }
}
