package com.deerpointgroup.deerpointliquorstore.cart;


import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.product.ProductService;
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
    private final ProductService productService;

    public CartController(CartService cartService, UserService userService, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
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

    @RequestMapping(path="/addCart", method = RequestMethod.POST)
    public Cart addNewCartItem(Principal principal, @RequestParam(required = true) long productId){
        List<Cart> listCart = cartService.getCartListUser( ( (User) userService.loadUserByUsername(principal.getName())) );
        int quantity = 0;
        for(int i = 0; i < listCart.size(); i++){

            if(listCart.get(i).getProduct().getProductID() == productId){
                quantity = listCart.get(i).getQuantity()+1;
                 return cartService.updateCart(listCart.get(i), quantity);
            }
        }
        if(!(listCart.contains(productId))){
            return cartService.addNewProductToCart(productId,( (User) userService.loadUserByUsername(principal.getName()) ).getId() , quantity+1);
        }
        return null;
    }

    @RequestMapping(path="/deleteCart", method = RequestMethod.POST)
    public Cart deleteItemCart(Principal principal, @RequestParam(required = true) long productId){
        List<Cart> listCart = cartService.getCartListUser( ( (User) userService.loadUserByUsername(principal.getName())) );
        int quantity = 0;
        for(int i = 0; i < listCart.size(); i++){
            if(listCart.get(i).getProduct().getProductID() == productId){
                if(listCart.get(i).getQuantity() == 1 && listCart.get(i).getProduct().getProductID() == productId) {
                    return cartService.deleteCart(listCart.get(i).getCartID());
                }else{
                    return cartService.updateQuantity(listCart.get(i), listCart.get(i).getQuantity()-1);
                }
            }
        }

        return null;
    }

    @RequestMapping(path="/cartTotal", method = RequestMethod.GET)
    public double getAllProductsInCart(Principal principal){
        return cartService.getCartTotal((User)userService.loadUserByUsername(principal.getName()));
    }


}
