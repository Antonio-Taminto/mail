package com.mail.services;

import com.mail.entities.User;
import com.mail.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createUser(User user){
        return repository.save(user);
    }
    public Optional<User> getUser(Long id){
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()){
            return userOptional;
        }else {
            return Optional.empty();
        }
    }
    public List<User> getUserList(){
        return repository.findAll();
    }

    public Optional<User> updateUser(Long id,User user){
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()){
            userOptional.get().setName(user.getName());
            userOptional.get().setEmail(user.getEmail());
            userOptional.get().setEmailPassword(user.getEmailPassword());
            User savedUser = repository.save(userOptional.get());
            return Optional.of(savedUser);
        }else {
            return Optional.empty();
        }
    }
    public Optional<User> deleteUser(Long id){
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()){
            repository.deleteById(userOptional.get().getId());
            return userOptional;
        }else {
            return Optional.empty();
        }
    }
}
