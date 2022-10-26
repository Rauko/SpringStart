package com.example.demo.services;

import com.example.demo.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
//@Repository
//@Component
public class UserService {
    private static List<User> users = new ArrayList<>();

    static {
        User myUser1 = new User(1L, "name1");
        User myUser2 = new User(2L, "name2");
        User myUser3 = new User(3L, "name3");

        users.add(myUser1);
        users.add(myUser2);
        users.add(myUser3);
    }

    public User getUserById(Long id){
        return UserService.users.stream().filter(u -> u.getId() == id).findFirst().orElse(new User(0L, "user0"));
    }

    public List<User> getAllUsers(){
        return UserService.users;
    }


    public User addUser(User user){
        UserService.users.add(user);
        return UserService.users.get(UserService.users.size() - 1);
    }

    public void deleteUser(Long id){
        UserService.users.removeIf(u -> u.getId() == id);
    }

    public List<User> editUserName(Long id, String name){
        UserService.users = UserService.users.stream()
                .map(u -> u.getId() == id ? new User(u.getId(), name) : u)
                .collect(Collectors.toList());
        return UserService.users.stream().filter(u -> u.getId() == id).collect(Collectors.toList());
    }
}
