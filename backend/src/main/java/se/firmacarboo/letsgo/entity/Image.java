package se.firmacarboo.letsgo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document(collection="Images")
public class Image extends BaseEntity{

//    @Id
//    private String id;
//    private String name;

    //Makes image URL unique, which will prevent entering duplicates
    @Indexed(unique = true)
    private String imageUrl;
    private String imageAltText;
    private UsageType usageType;
    private LocalDateTime created;

//    public Image(String name, String imageUrl, String imageAltText, UsageType usageType, LocalDateTime created) {
//        this.name = name;
//        this.imageUrl = imageUrl;
//        this.imageAltText = imageAltText;
//        this.usageType = usageType;
//        this.created = created;
//    }
}
