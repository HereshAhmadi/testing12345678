package com.deerpointgroup.deerpointliquorstore.employee;

import com.deerpointgroup.deerpointliquorstore.product.ProductService;
import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.security.Principal;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(Principal principal){
        return userService.loadUserByUsername(principal.getName()).getUsername() + "," +
                ((User)userService.loadUserByUsername(principal.getName())).getRole();
    }

    @RequestMapping(value = "/productSold", method = RequestMethod.POST)
    public String productSold(@RequestParam(required = true) Long id,
                              @RequestParam(required = true) int quantity)
            throws IOException, ServletException {

        String result = productService.productSold(id, quantity);
        return result;
    }


}
