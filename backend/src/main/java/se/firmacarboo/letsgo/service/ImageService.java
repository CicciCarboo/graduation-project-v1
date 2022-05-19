package se.firmacarboo.letsgo.service;

import se.firmacarboo.letsgo.entity.Image;
import java.util.List;
import java.util.Optional;

public interface ImageService {

    List<Image> getAllImages();
    Optional<Image> getImageById(String id);
    Optional<Image> getImageByImageUrl(String imageUrl);
    String registerNewImage(Image image);
    Image updateImage(String id);
    void deleteImage(String id);
}
