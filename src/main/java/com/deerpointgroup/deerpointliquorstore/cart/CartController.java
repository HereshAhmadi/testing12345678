package com.deerpointgroup.deerpointliquorstore.cart;


import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(path="/cartList", method = RequestMethod.GET)
    public List<Cart> getAllProductsInCart(){
        return cartService.getCartList();
    }

    @RequestMapping(path="/cartListByUser", method = RequestMethod.GET)
    public List<Cart> getAllProductsInUserCart(){
        User user = new User();
        long i = 2;
        user.setId(i);
        return cartService.getCartListUser(user);
    }
}
