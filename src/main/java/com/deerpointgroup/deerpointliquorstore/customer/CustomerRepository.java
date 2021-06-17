/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.customer;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 699785
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Optional<Customer> findCustomerByEmail(String email);
    
     Optional<Customer> findUserByUsername(String username); 
}
