package com.deerpointgroup.deerpointliquorstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersRestController {
    @Autowired
    OrdersService ordersService;


    @GetMapping
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }
}
