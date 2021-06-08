/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 809882
 */
@Controller
@RequestMapping("/product")
public class ProductView {
        
    
    @RequestMapping(value = "/product", method= RequestMethod.GET)
    public String success(){
        return "product";
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.POST)
    public String fail(){
        return "home";
    }
}
