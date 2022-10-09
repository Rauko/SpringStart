package com.example.demo.services;

import com.example.demo.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
}
