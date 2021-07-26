/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.user;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.ServletException;

import com.deerpointgroup.deerpointliquorstore.Roles.Role;
import com.deerpointgroup.deerpointliquorstore.order.Orders;
import com.deerpointgroup.deerpointliquorstore.order.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 699785
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    OrdersService ordersService;

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
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editCustomer(Principal principal, 
            @RequestParam(required = true) String password,
            @RequestParam(required = true) String passwordRepeat, 
            @RequestParam(required = true) String email) throws IOException, ServletException {
        User user = (User) userService.loadUserByUsername(principal.getName());
        String result = userService.editCustomer(user, password, passwordRepeat, email);
        return result;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String getUserName(Principal principal) {
        return principal.getName();
    }
    
    
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public String getUserInfo(Principal principal) {
        return userService.loadUserByUsername(principal.getName()).getUsername() + "," +
                ((User)userService.loadUserByUsername(principal.getName())).getEmail();
    }

    @GetMapping("/orders")
    public List<Orders> getUserOrders(Principal principal){
        long userID = ((User)userService.loadUserByUsername(principal.getName())).getId();

        return ordersService.getAllOrders(userID);
    }




}
