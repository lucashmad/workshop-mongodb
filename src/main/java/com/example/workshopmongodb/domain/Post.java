package com.example.workshopmongodb.domain;

import com.example.workshopmongodb.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Post implements Serializable {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}
