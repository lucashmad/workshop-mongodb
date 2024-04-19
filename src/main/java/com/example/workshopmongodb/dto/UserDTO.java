package com.example.workshopmongodb.dto;

import com.example.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;

    public UserDTO(User data) {
        id = data.getId();
        name = data.getName();
        email = data.getEmail();
    }

}

