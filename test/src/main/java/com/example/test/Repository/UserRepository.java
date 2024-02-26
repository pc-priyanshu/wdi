package com.example.test.Repository;

import com.example.test.Entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsernameAndPassword(String username, String password);
}
