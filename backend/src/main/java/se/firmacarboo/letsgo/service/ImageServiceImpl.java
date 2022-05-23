package se.firmacarboo.letsgo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.repository.ImageRepository;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;

    @Override
    public Boolean existsByImageUrl(String imageUrl) {
        return imageRepository.existsByImageUrl(imageUrl);
    }

    @Override
    public List<Image> getAllImages() {
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

        if (existingImage.isEmpty()) {
            imageRepository.insert(image);
            message = "Image has been successfully inserted.";
        } else {
            message = "There is already an image with imageUrl: " + image.getImageUrl();
        }
        return message;

    }

    @Transactional
    @Override
    public String updateImage(Image image) {
        log.info("Running updateImage.");
        // .save() will return image the saved object
        // when using findById() in a @Transactional method, there is supposed no need for save(). I do not get it to work yet.

        String result;
        try {
            log.info("From updateImage: try findImageById(image.getId())");

            // use given object id to find object in database for update
            Optional<Image> imageFromDatabase = imageRepository.findById(image.getId());

            if (imageFromDatabase.isPresent()) {

                //if imageUrl is updated, make sure it's not already taken.
                if (!image.getImageUrl().equals(imageFromDatabase.get().getImageUrl())) {
                    log.info("From updateImage: New value for imageUrl provided.");

                    if (imageRepository.existsByImageUrl(image.getImageUrl())) {
                        throw new InstanceAlreadyExistsException();
                    }

//                    imageFromDatabase.get().setImageUrl(image.getImageUrl());
                }

//                // mapping new values to existing image
//                if(!image.getName().equals(imageFromDatabase.get().getName()))
//                    imageFromDatabase.get().setName(image.getName());
//
//                if(!image.getImageAltText().equals(imageFromDatabase.get().getImageAltText()))
//                    imageFromDatabase.get().setImageAltText(image.getImageAltText());
//
////              Todo:  if(!image.getMessage().equals(imageFromDatabase.get().getMessage()))
////                    imageFromDatabase.get().setMessage(image.getMessage());
//
//                if(!image.getUsageType().equals(imageFromDatabase.get().getUsageType()))
//                    imageFromDatabase.get().setUsageType(image.getUsageType());

                imageRepository.save(image);
                result = "Image successfully updated.";
            } else {
                throw new NoSuchElementException();
            }


        } catch (Exception e) {
            result = "" + e;
            log.error("From updateImage: an error occurred: '{}'", "Message: " + e);
        }

        return result;
    }

    @Override
    public Boolean deleteImageById(String id) {
        log.info("Running deleteImageById().");

        try {
            Optional<Image> existingImage = imageRepository.findById(id);

            if (existingImage.isPresent()) {
                imageRepository.deleteById(id);
                log.info("From deleteImageById(). Image with Id: {} successfully deleted.", id);
                return true;
            }else throw new NoSuchElementException();

        } catch (NoSuchElementException e) {
            log.error("From deleteImageById(). No document exists by given id. Error: {}", ""+e);
            return false;
        }
    }

    //This method is only intended for service use. Not to be used for API access.
    @Override
    public Optional<Image> getImageByImageUrl(String imageUrl) {
        return imageRepository.findImageByImageUrl(imageUrl);
    }

}
