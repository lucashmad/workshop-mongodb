package com.example.workshopmongodb.resources;

import com.example.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User userOne = new User("1", "Lucas", "lucas@gmail.com");
        User userTwo = new User("1", "Jean", "jean@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(userOne, userTwo));
        return ResponseEntity.ok().body(userList);
    }
}
