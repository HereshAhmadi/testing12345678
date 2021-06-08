/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 699785
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    

    private final CustomerService customerService;
    
    
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    
    
//    @PostMapping
//    public void registerNewStudent(@RequestBody Customer customer){
//        customerService.addNewCustomer(customer);
//    }
    
    @PostMapping
    public String registerNewCustomer( @RequestParam(required = true) String name,
                                    @RequestParam(required = true) String password,
                                    @RequestParam(required = true) String passwordRepeat,
                                    @RequestParam(required = true) String email){
        
        if(password.equals(passwordRepeat)){
            try{
               customerService.addNewCustomer(new Customer(name, password, email)); 
               return "Account Created";
            }catch(Exception e){
                return "Email already taken";
            }
            
        }else{
            return "Passwords do not match";
        }
        
    }
    
    @DeleteMapping(path = "{customerId}")
    public void deleteStudent(@PathVariable("customerId") Long customerId ){
        customerService.deleteCustomer(customerId);
    }
    
    //for updating
    @PutMapping(path = "{customerId}")
    public void updateStudent(@PathVariable("customerId") long customerId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        customerService.updateCustomer(customerId, name, email);
    }
    
    
}
