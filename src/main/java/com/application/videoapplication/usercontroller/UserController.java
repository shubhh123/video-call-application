package com.application.videoapplication.usercontroller;

import com.application.videoapplication.user.User;
import com.application.videoapplication.userservice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @PostMapping(path = "/login")
    public User login(@RequestBody  User user) {
        return userService.login(user);
    }


    @PostMapping("/logout")
    public void logout(String email) {
        userService.logout(email);
    }

    @GetMapping("/find")
    public List<User> findAll() {
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle (Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
}
}
