package se.firmacarboo.letsgo.service;

import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.repository.ImageRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageService {

    Boolean existsByImageUrl(String imageUrl);
    List<Image> getAllImages();
    Optional<Image> getImageById(String id);
    Optional<Image> getImageByImageUrl(String imageUrl);
    String registerNewImage(Image image);
    String updateImage(Image image);
    void deleteImage(String id);
}
