package se.firmacarboo.letsgo.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection="Images")
public class Image extends BaseEntity{

    //Makes image URL unique, which will prevent entering duplicates
    @Indexed(unique = true)
    private String imageUrl;
    private String imageAltText;
    private UsageType usageType;
}
