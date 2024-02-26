package com.example.test.Service;

import com.example.test.Entities.AppUser;
import com.example.test.Entities.Booking;
import com.example.test.Repository.BookingRepository;
import com.example.test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public void registerUser(AppUser user) {
        userRepository.save(user);
    }

    public boolean loginUser(AppUser user) {
        AppUser existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return existingUser != null;
    }

    public void bookBike(Booking booking) {
        booking.setBookingDate(new Date());
        bookingRepository.save(booking);
    }
}
