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
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(@RequestParam(required = true) String name,
            @RequestParam(required = true) String password,
            @RequestParam(required = true) String passwordRepeat,
            @RequestParam(required = true) String email) throws IOException, ServletException {

        String result = userService.addNewUser(name, password, passwordRepeat, email);
        return result;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String getUserName(Principal principal) {
        return principal.getName();
    }
    
    
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String getUserInfo(Principal principal) {
        return userService.loadUserByUsername(principal.getName()).getUsername() + "," +
                ((User)userService.loadUserByUsername(principal.getName())).getEmail();
    }
    
    
}
