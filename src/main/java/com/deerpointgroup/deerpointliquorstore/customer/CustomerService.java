/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.customer;

import com.deerpointgroup.deerpointliquorstore.product.Product;
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
        Customer user = customerRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }

    //create user
    private void createUser(UserDetails user) {
        customerRepository.save((Customer) user);
    }
    
    //
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    //register
    public String addNewCustomer(String name, String password, String repeatPassword, String email) {

        if (!password.equals(repeatPassword)) {

            return "your password does not match";
        }
        
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        password = bc.encode(password);
        
        
        Customer customer = new Customer(name, password, email);
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());

        if (customerOptional.isPresent()) {
            return "email taken";
        }


        createUser(customer);
        return "Account created";

    }

}
