/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.user;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 699785
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewCustomer(@RequestParam(required = true) String name,
            @RequestParam(required = true) String password,
            @RequestParam(required = true) String passwordRepeat,
            @RequestParam(required = true) String email) throws IOException, ServletException {

        String result = customerService.addNewCustomer(name, password, passwordRepeat, email);
        return result;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(Principal principal) {
        return principal.getName();
    }
    
    
}
