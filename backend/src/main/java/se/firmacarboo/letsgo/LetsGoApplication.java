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
}
