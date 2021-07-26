package com.deerpointgroup.deerpointliquorstore.order;

import com.deerpointgroup.deerpointliquorstore.cart.Cart;
import com.deerpointgroup.deerpointliquorstore.user.User;
import com.stripe.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public void addToOrders(Cart cart){
        Orders order = new Orders(cart.getUser(), cart.getProduct(), cart.getQuantity());
        ordersRepository.save(order);
    }

    public void addListToOrders(List<Cart> userCarts){
        for(int i = 0; i < userCarts.size(); i++){
            Orders order = new Orders(userCarts.get(i).getUser(), userCarts.get(i).getProduct(), userCarts.get(i).getQuantity());
            ordersRepository.save(order);
        }
    }

    public boolean verifyOrder(String orderCode){
        return ordersRepository.findOrdersByOrderCode(orderCode).isPresent();
    }

    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    public List<Orders> getAllOrders(long userID){
        return ordersRepository.findByUserId(userID);
    }
}
