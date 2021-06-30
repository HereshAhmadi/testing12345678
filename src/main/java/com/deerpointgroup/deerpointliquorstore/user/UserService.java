/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author 699785
 */
/**
 *
 * @author 699785
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //login
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not present"));
        return user;
    }

    //create user
    private void createUser(UserDetails user) {
        userRepository.save((User) user);
    }

    //get all users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //register
    public String addNewUser(String name, String password, String repeatPassword, String email) {

        if (!password.equals(repeatPassword)) {

            return "your password does not match";
        }

        if (password.length() < 8) {
            return "password must be at least 8 characters long";
        }

        if (name.length() < 8) {
            return "username must be at least 8 characters long";

        }

        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        password = bc.encode(password);

        User user = new User(name, password, email);
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if (userOptional.isPresent()) {
            return "email taken";
        }

        createUser(user);
        return "Account created";

    }
    
    //edit User
    public String editCustomer(User user, String password, String repeatPassword, String email) {
        if (!password.equals(repeatPassword)) {

            return "Your password does not match!";
        }

        if (password.length() < 8) {
            return "Password must be at least 8 characters long!";
        }

        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        password = bc.encode(password);
        user.setPassword(password);
        user.setEmail(email);
        Optional<User> customerOptional = userRepository.findUserByEmail(user.getEmail());

        if (!user.getEmail().equals(email)) {
            if (customerOptional.isPresent() && user.getEmail().equals(email)) {
                return "Email taken";
            }
        }

        userRepository.save((User) user);
        return "Account updated";

    }
    
   

}
