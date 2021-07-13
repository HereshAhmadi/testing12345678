package com.deerpointgroup.deerpointliquorstore.admin;

import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping
    public String getRole(Principal principal) {
        return ((User)userService.loadUserByUsername(principal.getName())).getUsername() +
        ((User)userService.loadUserByUsername(principal.getName())).getRole().getName();

    }
}
