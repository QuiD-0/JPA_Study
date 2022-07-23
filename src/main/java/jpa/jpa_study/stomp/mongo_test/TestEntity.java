package jpa.jpa_study.stomp.mongo_test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collation = "chat")
@Getter
@Setter
public class TestEntity {

    @Id
    private String id;

    private String name;
}
