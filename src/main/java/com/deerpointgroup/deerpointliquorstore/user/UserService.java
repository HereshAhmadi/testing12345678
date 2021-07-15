/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.deerpointgroup.deerpointliquorstore.Roles.Role;
import com.deerpointgroup.deerpointliquorstore.Roles.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //login
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUsernameIgnoreCase(username)
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

        Optional<User> userByEmail = userRepository.findUserByEmailIgnoreCase(email);
        Optional<User> userByName = userRepository.findUserByUsernameIgnoreCase(name);

        if (userByEmail.isPresent()) {
            return "email taken";
        }

        if (userByName.isPresent()) {
            return "User with this name already exists";
        }

        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        password = bc.encode(password);
        User user = new User(name, password, email, rolesRepository.getById(3L));
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

        Optional<User> userByEmail = userRepository.findUserByEmailIgnoreCase(email);

        if (user.getEmail().equals(email) || userByEmail.isPresent()) {
            return "Email taken";
        }

        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        password = bc.encode(password);
        user.setPassword(password);
        user.setEmail(email);
        userRepository.save((User) user);
        return "Account updated";

    }
    
   

}
