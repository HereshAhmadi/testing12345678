package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

class CartService {
    
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }


    public void deleteCart(long cartID){
        boolean exists = cartRepository.existsById(cartID);
        
       if(!exists){
           throw new IllegalStateException("Cart with id" + cartID + " does not exist");
       }
       
       cartRepository.deleteById(cartID);
    }

    public void addNewCart(Cart cart){
       Optional<Product> cartOptional = cartRepository.findCartByID(cart.getCartID());
       
       if(cartOptional.isPresent()){
           throw new IllegalStateException("Cart already in database");
       }else{
           cartRepository.save(cart);
       }
     }

    void updateCart(long cartID, List<Product> pList) {
        
    }
    
}
