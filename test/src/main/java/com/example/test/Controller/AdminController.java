package com.example.test.Controller;

import com.example.test.Entities.AppAdmin;
import com.example.test.Entities.Bike;
import com.example.test.Entities.Booking;
import com.example.test.Service.AdminService;
import com.example.test.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class    AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BikeService bikeService;

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody AppAdmin appAdmin) {
        if (adminService.loginAdmin(appAdmin)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/add")
    public void addBike(@RequestBody Bike bike) {
        bikeService.addBike(bike);
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return adminService.getAllBookings();
    }

    @GetMapping("/user/{userId}/bookings")
    public List<Booking> getUserBookings(@PathVariable Long userId) {
        return adminService.getUserBookings(userId);
    }
}
