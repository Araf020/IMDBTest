package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {
    
    public User findByEmailAddress(String emailAddress);
}
