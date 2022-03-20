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
        // TODO Returns null now if no Image found. Create request body and handle if Optional equals null.
        return imageRepository.findById(id);
    }

    //This method is only intended for service use. Not to be used for API access.
    @Override
    public Optional<Image> getImageByImageUrl(String imageUrl) {
        imageRepository.findImageByImageUrl(imageUrl)
                    .ifPresentOrElse(i -> {
                                System.out.println("from getImageByImageUrl: Image already exist by imageUrl: "
                                        + imageUrl);
                            }, () -> {
                                System.out.println("from getImageByImageUrl: There is no image with the imageUrl: "
                                        + imageUrl);
                            }
                    );
        return Optional.empty();
    }

    @Override
    public String registerNewImage(Image image) {
//        TODO on registration check that imageUrl doesn't already exist in db
        Optional existingImage = getImageByImageUrl(image.getImageUrl());

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
}
