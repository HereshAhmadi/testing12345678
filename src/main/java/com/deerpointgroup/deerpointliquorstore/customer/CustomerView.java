/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 699785
 */
@Controller
@RequestMapping("/customer")
public class CustomerView {
        
    
    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String success(){
        return "home";
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.POST)
    public String fail(){
        return "home";
    }
}
