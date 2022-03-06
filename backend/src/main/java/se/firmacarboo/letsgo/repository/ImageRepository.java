package se.firmacarboo.letsgo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.firmacarboo.letsgo.entity.Image;

public interface ImageRepository  extends MongoRepository<Image, String> {
}
