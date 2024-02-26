package com.example.test.Controller;

import com.example.test.Entities.AppUser;
import com.example.test.Entities.Booking;
import com.example.test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody AppUser appUser) {
        userService.registerUser(appUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AppUser appUser) {
        if (userService.loginUser(appUser)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/book-bike")
    public void bookBike(@RequestBody Booking booking) {
        userService.bookBike(booking);
    }
}
