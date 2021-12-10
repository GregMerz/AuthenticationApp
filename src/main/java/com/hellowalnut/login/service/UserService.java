package com.hellowalnut.login.service;

import java.util.List;

import com.hellowalnut.login.exception.ResourceNotFoundException;
import com.hellowalnut.login.exception.UserAlreadyMadeException;
import com.hellowalnut.login.model.User;
import com.hellowalnut.login.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepo;
    PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findUserByUsername(User user) throws ResourceNotFoundException {
        List<User> users = findAll();

        for (User userInDB : users) {
            if (userInDB.getUsername().equals(user.getUsername())) {
                return userInDB;
            }
        }

        throw new ResourceNotFoundException("User not found");
    }

    public User findUserById(Long id) throws ResourceNotFoundException {
        User user = userRepo.findById(id)
		 					.orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return user;
    }

    public User save(User user) throws UserAlreadyMadeException {
        try {
            findUserByUsername(user);
        } catch (ResourceNotFoundException e) {
            String encodedPassword = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            return this.userRepo.save(user);
        } 

        throw new UserAlreadyMadeException("User already made");
    }

    public User validateUser(User user) throws ResourceNotFoundException {
        User userInDB = findUserByUsername(user);

        if (this.passwordEncoder.matches(user.getPassword(), userInDB.getPassword())) {
            return userInDB;
        }

        throw new ResourceNotFoundException("Resourse not found");
    }
}
