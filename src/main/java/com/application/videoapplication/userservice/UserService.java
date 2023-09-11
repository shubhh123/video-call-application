package com.application.videoapplication.userservice;

import com.application.videoapplication.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_LIST = new ArrayList<>();

    public void register(User user) {
        user.setStatus("online");
        USERS_LIST.add(user);
    }

    public User login(User user) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i->USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User Not Found from login"));

        var connectedUser = USERS_LIST.get(userIndex);

        if(!connectedUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password Incorrect");
        }
        connectedUser.setStatus("online");
        return connectedUser;
    }

    public void logout(String email) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i->USERS_LIST.get(i).getEmail().equals(email))
                // findAny() -> It effectively finds the first index that matches the email condition.
                .findAny()
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public List<User> findAll() {
        return USERS_LIST;
    }
}
