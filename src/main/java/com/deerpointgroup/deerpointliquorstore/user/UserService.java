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
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }

    //create user
    private void createUser(UserDetails user) {
        userRepository.save((User) user);
    }

    //
    public List<User> getCustomers() {
        return userRepository.findAll();
    }

    //register
    public String addNewCustomer(String name, String password, String repeatPassword, String email) {

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

        User customer = new User(name, password, email);
        Optional<User> customerOptional = userRepository.findCustomerByEmail(customer.getEmail());

        if (customerOptional.isPresent()) {
            return "email taken";
        }

        createUser(customer);
        return "Account created";

    }

}
