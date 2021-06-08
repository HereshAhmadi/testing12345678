/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.customer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 699785
 */
/**
 *
 * @author 699785
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    
    
    public String addNewCustomer(String name, String password, String repeatPassword, String email){
        
        if(!password.equals(repeatPassword)){
         
            return "your password does not match";
        }
        
       Customer customer = new Customer(name,password,email);
       Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
       
       if(customerOptional.isPresent()){
           return "email taken";
       }
          
       
       customerRepository.save(customer);
       return "Account created";
      
     }
    
    
    
    public void deleteCustomer(long customerId){
        boolean exists = customerRepository.existsById(customerId);
        
       if(!exists){
           throw new IllegalStateException("Customer with id" + customerId + " does not exist");
       }
       
       customerRepository.deleteById(customerId);
    }
    
    
    @Transactional
    public void updateCustomer(long customerId, String name, String email){
        boolean exists = customerRepository.existsById(customerId);
        
        if(!exists){
            throw new IllegalStateException("Customer with " + customerId +" does not exists");
        }
        
        Customer customer = customerRepository.getById(customerId);
        
        if(name != null & name.equals(" ") && !Objects.equals(customer.getName(), name)){
           customer.setName(name); 
        }
        
        if(email != null & email.equals(" ") && !Objects.equals(customer.getEmail(), email)){
            
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            
                if(customerOptional.isPresent()){
                    throw new IllegalStateException("Email taken");
                }
            customer.setEmail(email);
        }
    }
}