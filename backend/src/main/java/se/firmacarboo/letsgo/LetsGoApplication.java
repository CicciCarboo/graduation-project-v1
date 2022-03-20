package se.firmacarboo.letsgo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.entity.UsageType;
import se.firmacarboo.letsgo.repository.ImageRepository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class LetsGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetsGoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(ImageRepository imageRepository,
//                             MongoTemplate mongoTemplate) {
//        return args -> {
//            String imageUrl = "../images";
//            String imageUrl2 = "../images/eatBreakfast";
////            Image image = new Image( // Not working for now due to that it's constructor is inactivated
////                    "GatchaBrushTeeth",
////                    imageUrl,
////                    "Gatchafigur som borstar tänderna",
////                    UsageType.BRUSHTEETH,
////                    LocalDateTime.now()
////            );
//
//            Image image = new Image();
//            image.setName("GatchaEatBreakfast");
//            image.setImageUrl(imageUrl2);
//
//            //Make a database query that finds all elements that have the given imageUrl.
////            findImageByUrlUsingMongoTemplateAndQuery(imageRepository, mongoTemplate, imageUrl, image);
//
//            imageRepository.findImageByImageUrl(imageUrl2)
//                    .ifPresentOrElse(i -> {
//                                System.out.println("Image already exist");
//                            }, () -> {
//                                imageRepository.insert(image);
//                                System.out.println("Image has been successfully inserted in database.");
//                            }
//                    );
//
//        };
//    }

    private void findImageByUrlUsingMongoTemplateAndQuery(ImageRepository imageRepository, MongoTemplate mongoTemplate, String imageUrl, Image image) {
        Query query = new Query();
        query.addCriteria(Criteria.where("imageUrl").is(imageUrl));

        //List all elements found by the query
        List<Image> images = mongoTemplate.find(query, Image.class);
        System.out.println("This is List 'images', populated by images from database via query: " + images);

        //If the list of images does carry any elements = is lager than 1 index, abort insert.
        if (images.size() > 0) {
            System.out.println("Image already exist");
            throw new IllegalStateException("Found many images with URL: " + imageUrl);
        } else {
            //Insert new image in DB
            System.out.println("Image has been successfully inserted in database.");
            imageRepository.insert(image);
        }
    }

}
