package com.example.vetapp.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService service;

    @PostMapping("/registeruser")
    public User register(@RequestBody User user) throws Exception {
        String email = user.getEmailId();
        if(email != null && !"".equals(email)){
            User userObj = service.fetchUserByEmail(email);
            if(userObj != null){
                throw new Exception("user with " + email + " is already exist");
            }
        }
        return service.saveUser(user);
    }
    @GetMapping
    public String hello(){
        return "Welcome to my homepage";
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String email = user.getEmailId();
        String pass = user.getPassword();
        User userObj = null;
        if(email != null && pass != null){
            userObj = service.fetchUserByEmailAndPassword(email, pass);
        }
        if(userObj == null){
            throw new Exception("bad creden");
        }
        return userObj;
    }

}
