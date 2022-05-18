package se.firmacarboo.letsgo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class BaseEntity {

    @Id
    private String id; //TODO change to ObjectId??? @ID for Spring context, how is it connected to -id: ObjectId(vnjsgnjk...)?
    private String name;
}
