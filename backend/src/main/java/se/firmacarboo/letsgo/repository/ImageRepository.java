package se.firmacarboo.letsgo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.firmacarboo.letsgo.entity.Image;

import java.util.Optional;

public interface ImageRepository  extends MongoRepository<Image, String> {

    //TODO you should disable the use of arbitrary JavaScript by setting javascriptEnabled:false in the config file. / https://www.infoq.com/articles/Starting-With-MongoDB/
    Optional<Image> findImageByImageUrl(String imageUrl);
}
