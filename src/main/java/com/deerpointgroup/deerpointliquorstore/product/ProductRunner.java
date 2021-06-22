package com.deerpointgroup.deerpointliquorstore.product;

import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

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

    }

}
