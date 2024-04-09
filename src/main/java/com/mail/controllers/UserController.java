package com.mail.controllers;

import com.mail.entities.User;
import com.mail.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(service.createUser(user));
    }
    @GetMapping("/fromid/{id}")
    public ResponseEntity<User> userFromId(@PathVariable Long id){
        Optional<User> userOptional = service.getUser(id);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<User>> userList(){
        return ResponseEntity.ok(service.getUserList());
    }
    @PutMapping("/update/fromid/{id}")
    public ResponseEntity<User> updateFromId(@PathVariable Long id,@RequestBody User user){
        Optional<User> userOptional = service.updateUser(id,user);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/delete/fromid/{id}")
    public ResponseEntity<User> deleteUserFromId(@PathVariable Long id){
        Optional<User> userOptional = service.deleteUser(id);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
