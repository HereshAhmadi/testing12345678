package com.deerpointgroup.deerpointliquorstore.product;

import com.deerpointgroup.deerpointliquorstore.cart.Cart;
import com.deerpointgroup.deerpointliquorstore.cart.CartRepository;
import com.deerpointgroup.deerpointliquorstore.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.deerpointgroup.deerpointliquorstore.user.UserRepository;

@Component
public class ProductRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {
        
        //products
        productRepository.save(new Product("Kim Crowford", "A sauvignon blanc, passion fruit, gooseberry, bursting with flavour. ", 2, 19.99));
        productRepository.save(new Product("Longshot", "A cabernet sauvignon, Californian wine rich with flavour and ruby in color. ", 1, 16.99));
        productRepository.save(new Product("Beringer", "A cabernet sauvignon, dark fruit, chocolar and spice flavours with a hint of vanilla. ", 3, 9.99));
        productRepository.save(new Product("Terermana", "A smooth tequilla, notes of bright citrus with a fresh finish ", 5, 26.99));
        productRepository.save(new Product("Pink Whitney", "Vodka infused with fresh pink lemonade, creating a balance of sweetness and refreshing taste", 8, 29.99));

        //users
        userRepository.save(new User("user", "$2y$12$oejcFX2l1bgRS1339yd6heJ/aSA/qVSYb68FAAe6w6I.9oji3WmSO", "email@gmail.com"));
        userRepository.save(new User("user1", "$2y$12$oejcFX2l1bgRS1339yd6heJ/aSA/qVSYb68FAAe6w6I.9oji3WmSO", "email@gmail.com"));
        userRepository.save(new User("user2", "$2y$12$oejcFX2l1bgRS1339yd6heJ/aSA/qVSYb68FAAe6w6I.9oji3WmSO", "email@gmail.com"));

        //cart
        long i = 1;
        long ii = 2;
        long iii = 3;
        cartRepository.save(new Cart(productRepository.getById(i), userRepository.getById(i), 1));
        cartRepository.save(new Cart(productRepository.getById(ii), userRepository.getById(ii), 1));
        cartRepository.save(new Cart(productRepository.getById(iii), userRepository.getById(iii), 1));

    }

}
