package com.example.test.Repository;

import com.example.test.Entities.AppAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AppAdmin, Long> {
    AppAdmin findByUsernameAndPassword(String username, String password);
}
