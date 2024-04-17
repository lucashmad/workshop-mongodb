package com.example.workshopmongodb.service;

import com.example.workshopmongodb.domain.User;
import com.example.workshopmongodb.repository.UserRepository;
import com.example.workshopmongodb.service.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
      Optional<User> user = repository.findById(id);
      return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

}

