package com.example.test.Service;

import com.example.test.Entities.Bike;
import com.example.test.Repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public void addBike(Bike bike) {
        bikeRepository.save(bike);
    }

    public List<Bike> getBikes() {
        return bikeRepository.findAll();
    }
}
