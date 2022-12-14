package com.example.demo.controllers;

import com.example.demo.dto.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        var user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAll(){
        var users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        var addedUser = userService.addUser(user);
        return ResponseEntity.ok().body(addedUser);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{id}/{name}")
    public ResponseEntity<List<User>> editUserName(@PathVariable Long id, @PathVariable  String name){
        var updatedUsers = userService.editUserName(id, name);
        return ResponseEntity.ok().body(updatedUsers);
    }
}


// прочитать про статику
// локальные и глобальные переменные
// списки (list)
// функции и предикаты
// поиграть с маппингами
// зарегистрироваться на mongo db atlas
//