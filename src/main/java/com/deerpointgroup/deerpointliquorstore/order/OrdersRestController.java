package com.deerpointgroup.deerpointliquorstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrdersRestController {
    @Autowired
    OrdersService ordersService;


    @GetMapping
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @PostMapping("/orderCode")
    public Optional<Orders> getOrder(@RequestParam(required=true) String orderCode){
        return ordersService.verifyOrder(orderCode);
    }
}
