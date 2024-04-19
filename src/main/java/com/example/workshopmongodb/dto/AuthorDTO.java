package com.example.workshopmongodb.dto;

import com.example.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO(User author){
        id = author.getId();
        name = author.getName();
    }
}
