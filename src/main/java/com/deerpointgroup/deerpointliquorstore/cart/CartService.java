package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }
    public List<Cart> getCartListUser(User user){
        return cartRepository.findByUser(user);
    }
}
