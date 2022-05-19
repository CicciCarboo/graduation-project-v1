package se.firmacarboo.letsgo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages(){
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> getImageById(String id) {
        return imageRepository.findById(id);
    }

    @Override
    public String registerNewImage(Image image) {
        Optional<Image> existingImage = getImageByImageUrl(image.getImageUrl());

        String message;

        if(existingImage.isEmpty()){
            imageRepository.insert(image);
            message = "Image has been successfully inserted.";
        }else{
            message = "There is already an image with imageUrl: " + image.getImageUrl();
        }
        return message;

    }

    @Override
    public Image updateImage(String id) {
        return null;
    }

    @Override
    public void deleteImage(String id) {

    }

    //This method is only intended for service use. Not to be used for API access.
    @Override
    public Optional<Image> getImageByImageUrl(String imageUrl) {
        return imageRepository.findImageByImageUrl(imageUrl);
    }

}
