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
    public ResponseEntity registerNewImage(@RequestBody Image image){
        return new ResponseEntity(imageServiceImpl.registerNewImage(image), HttpStatus.OK);
    }


    /*
    * Template
    * @GetMapping("/age")
ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
    if (isInFuture(yearOfBirth)) {
        return ResponseEntity.badRequest()
            .body("Year of birth cannot be in the future");
    }

    return ResponseEntity.status(HttpStatus.OK)
        .body("Your age is " + calculateAge(yearOfBirth));
}*/

    @PutMapping("/update-image")
    public ResponseEntity<String> updateImage(@RequestBody Image image){
        String result = imageServiceImpl.updateImage(image);

        if(!result.equals("Image successfully updated.")){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(result);
    }
}
