package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    
    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getCart(){
        return cartService.getCart();
    }
    
    
    @PostMapping
    public String newCart( @RequestParam(required = true) List<Product> pList){

               cartService.addNewCart(new Cart(pList)); 
        return null;
    }
    
    @DeleteMapping(path = "{cartID}")
    public void deleteCart(@PathVariable("cartID") Long cartID ){
        cartService.deleteCart(cartID);
    }
    
    //for updating
    @PutMapping(path = "{cartID}")
    public void updateStudent(@PathVariable("cartID") long cartID,
                              @RequestParam(required = false) List<Product> pList
                             ){
        cartService.updateCart(cartID, pList);
    }
    
    
}
