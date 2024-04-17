package com.example.workshopmongodb.service;

import com.example.workshopmongodb.domain.User;
import com.example.workshopmongodb.dto.UserDTO;
import com.example.workshopmongodb.repository.UserRepository;
import com.example.workshopmongodb.exception.ObjectNotFoundException;
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

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO dataDTO){
        return new User(dataDTO.getId(), dataDTO.getName(), dataDTO.getEmail());
    }


    public User update(User user){
        User users = findById(user.getId());
        updateData(users, user);
        return repository.save(users);
    }

    private void updateData(User users, User user) {
        users.setName(user.getName());
        users.setEmail(users.getEmail());
    }

}

