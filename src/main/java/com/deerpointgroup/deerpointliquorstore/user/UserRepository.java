/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 699785
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findCustomerByEmail(String email);
    
    Optional<User> findUserByUsername(String username); 
}
