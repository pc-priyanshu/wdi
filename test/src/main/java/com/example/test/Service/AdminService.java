package com.example.test.Service;

import com.example.test.Entities.AppAdmin;
import com.example.test.Entities.Booking;
import com.example.test.Repository.AdminRepository;
import com.example.test.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public boolean loginAdmin(AppAdmin admin) {
        AppAdmin existingAdmin = adminRepository.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
        return existingAdmin != null;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
