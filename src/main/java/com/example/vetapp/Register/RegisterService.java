package com.example.vetapp.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public User fetchUserByEmail(String email){
        return repo.findByEmailId(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password){
        return repo.findByEmailIdAndPassword(email, password);
    }
}
