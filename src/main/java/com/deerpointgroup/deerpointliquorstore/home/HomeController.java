/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 699785
 */
@Controller
public class HomeController {
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    
    
    @RequestMapping(value = "/viewCustomer", method = RequestMethod.GET)
    public String viewCustomers(){
        return "viewCustomer";
    }
}
