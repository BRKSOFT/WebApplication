package com.example.vetapp.Register;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vetapp.Register.User;

public interface RegisterRepository extends JpaRepository<User, Integer> {
    public User findByEmailId(String email);
    public User findByEmailIdAndPassword(String email, String password);
}
