package com.example.workshopmongodb.service;

import com.example.workshopmongodb.domain.Post;
import com.example.workshopmongodb.exception.ObjectNotFoundException;
import com.example.workshopmongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> searchControl(String text, Date menDate, Date maiDate){
            maiDate = new Date(maiDate.getTime() + 24 * 60 * 60 * 1000); // contendo 24h
            return repository.searchControl(text, menDate, maiDate);
    }

}
