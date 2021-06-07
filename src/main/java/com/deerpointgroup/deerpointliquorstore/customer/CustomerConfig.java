/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.customer;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author 699785
 */
@Configuration
public class CustomerConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args ->{
           Customer heresh =  new Customer("heresh","passwod", "yoyo@gmail.com");
       
         Customer bob =  new Customer("bob","pass", "hello@gmail.com");
         
         
         
         repository.saveAll(List.of(heresh,bob));

        };
    }
}
