package com.deerpointgroup.deerpointliquorstore.cart;


import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @RequestMapping(path="/cartList", method = RequestMethod.GET)
    public List<Cart> getAllProductsInCart(){
        return cartService.getCartList();
    }

    @RequestMapping(path="/cartListByUser", method = RequestMethod.GET)
    public List<Cart> getAllProductsInUserCart(Principal principal){
        User user = (User) userService.loadUserByUsername(principal.getName());
        return cartService.getCartListUser(user);
    }

    @RequestMapping(path="/updateCart", method = RequestMethod.POST)
    public List<Cart> addNewCartItem(Principal principal, @RequestParam(required = true) int quantity) throws IOException, ServletException {
        User user = (User) userService.loadUserByUsername(principal.getName());
        List<Cart> carts = cartService.getCartListUser(user);
        for (int i =0; i < carts.size(); i++){
            cartService.updateQuantity(carts.get(i), carts.get(i).getQuantity());
        }
        return cartService.getCartListUser(user);
    }

    @RequestMapping(path="/cartTotal", method = RequestMethod.GET)
    public double getAllProductsInCart(Principal principal){
        return cartService.getCartTotal((User)userService.loadUserByUsername(principal.getName()));

    }

}
