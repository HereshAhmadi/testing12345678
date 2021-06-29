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
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    //login
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Customer user = customerRepository.findCustomerByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not present"));
        return user;
    }

    //create user
    private void createCustomer(UserDetails user) {
        customerRepository.save((Customer) user);
    }

    //get all users
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
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

        Customer customer = new Customer(name, password, email);
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());

        if (customerOptional.isPresent()) {
            return "email taken";
        }

        createCustomer(customer);
        return "Account created";

    }
    
   

}
