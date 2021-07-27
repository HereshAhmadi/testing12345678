package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.product.ProductRepository;
import com.deerpointgroup.deerpointliquorstore.product.ProductRunner;
import com.deerpointgroup.deerpointliquorstore.product.ProductService;
import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }

    public List<Cart> getCartListUser(User user){
        return cartRepository.findByUser(user);
    }

    //for delete and add
//    public Cart getCartProductForThatSpecificUser(User user, String productName){
//        List<Cart> userCarts = cartRepository.findByUser(user);
//        for(int i = 0; i < userCarts.size(); i++){
//
//            if((userCarts.get(i).getProduct().getProductName().equals(productName))){
//                return userCarts.get(i);
//            }
//        }
//        return null;
//    }

    public Cart addNewProductToCart(long productId, long userId, int quantity){
        return cartRepository.save(new Cart(productRepository.findByProductID(productId), userRepository.getById(userId), quantity));
    }

    //my update when adding
    public Cart updateCart(Cart cart, int quantity){
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public Cart deleteCart(long cartId){
        cartRepository.deleteById(cartId);
        return cartRepository.getById(cartId);
    }

    //nam code
    public Cart updateQuantity(Cart cart, int quantity){
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public double getCartTotal(User user){
        double total = 0;
        List<Cart> userCarts = cartRepository.findByUser(user);
        for(int i = 0; i < userCarts.size(); i++){
            total += userCarts.get(i).getProduct().getProductPrice() * userCarts.get(i).getQuantity();
        }

        return total;
    }

    public void deleteAll(User user){
       List<Cart> userCart = cartRepository.findByUser(user);
        for(int i = 0; i < userCart.size(); i++){
            cartRepository.delete(userCart.get(i));
        }
    }

}
