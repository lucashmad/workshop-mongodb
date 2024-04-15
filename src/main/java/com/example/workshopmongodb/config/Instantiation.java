package com.example.workshopmongodb.config;

import com.example.workshopmongodb.domain.User;
import com.example.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User userOne = new User(null, "Lucas", "lucas@gmail.com");
        User userTwo = new User(null, "Jean", "jean@gmail.com");
        User userTree = new User(null, "Luciana", "luciana@gmail.com");

        repository.saveAll(Arrays.asList(userOne, userTwo, userTree));


    }
}
