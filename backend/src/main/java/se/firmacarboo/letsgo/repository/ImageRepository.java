package se.firmacarboo.letsgo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.firmacarboo.letsgo.entity.Image;

import java.util.Optional;

public interface ImageRepository  extends MongoRepository<Image, String> {

    Optional<Image> findImageByImageUrl(String imageUrl);
}
