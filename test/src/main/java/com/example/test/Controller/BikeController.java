package com.example.test.Controller;

import com.example.test.Entities.Bike;
import com.example.test.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/list")
    public List<Bike> getBikes() {
        return bikeService.getBikes();
    }
}
