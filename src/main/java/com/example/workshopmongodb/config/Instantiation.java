package com.example.workshopmongodb.config;

import com.example.workshopmongodb.domain.Post;
import com.example.workshopmongodb.domain.User;
import com.example.workshopmongodb.dto.AuthorDTO;
import com.example.workshopmongodb.repository.PostRepository;
import com.example.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository repository;

   @Autowired
   private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();

        User userOne = new User(null, "Lucas", "lucas@gmail.com");
        User userTwo = new User(null, "Jean", "jean@gmail.com");
        User userTree = new User(null, "Luciana", "luciana@gmail.com");
        repository.saveAll(Arrays.asList(userOne, userTwo, userTree));
        
        Post postOne = new Post(null, simpleDateFormat.parse("21/03/2018"), "Bora viajar", "Partiu Rio de janeiro", new AuthorDTO(userOne));
        Post postTwo = new Post(null, simpleDateFormat.parse("19/08/2021"), "Pedra azul", "Pedra azul esta frio", new AuthorDTO(userTree));
        postRepository.saveAll(Arrays.asList(postOne, postTwo));

    }
}
