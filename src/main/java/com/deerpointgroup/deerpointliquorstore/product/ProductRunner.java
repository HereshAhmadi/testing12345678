package com.deerpointgroup.deerpointliquorstore.product;

import com.deerpointgroup.deerpointliquorstore.Roles.Role;
import com.deerpointgroup.deerpointliquorstore.Roles.RolesRepository;
import com.deerpointgroup.deerpointliquorstore.cart.Cart;
import com.deerpointgroup.deerpointliquorstore.cart.CartRepository;
import com.deerpointgroup.deerpointliquorstore.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.deerpointgroup.deerpointliquorstore.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void run(String... args) throws Exception {
        
        //products
        productRepository.save(new Product("Kim Crowford", "A sauvignon blanc, passion fruit, gooseberry, bursting with flavour. ", 2, 19.99));
        productRepository.save(new Product("Longshot", "A cabernet sauvignon, Californian wine rich with flavour and ruby in color. ", 20, 16.99));
        productRepository.save(new Product("Beringer", "A cabernet sauvignon, dark fruit, chocolar and spice flavours with a hint of vanilla. ", 3, 9.99));
        productRepository.save(new Product("Terermana", "A smooth tequilla, notes of bright citrus with a fresh finish ", 5, 26.99));
        productRepository.save(new Product("Pink Whitney", "Vodka infused with fresh pink lemonade, creating a balance of sweetness and refreshing taste", 8, 29.99));

        //roles
        Role adminRole = new Role("admin");
        Role employeeRole = new Role("employee");
        Role customerRole = new Role("customer");

        rolesRepository.save(adminRole);
        rolesRepository.save(employeeRole);
        rolesRepository.save(customerRole);


        //old code but keep for now please
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("admin"));
//        authorities.add(new SimpleGrantedAuthority("customer"));
//
//        rolesRepository.save(new Role(authorities.get(0).toString()));
//        rolesRepository.save(new Role(authorities.get(1).toString()));




        //users
        userRepository.save(new User("user", "$2y$12$oejcFX2l1bgRS1339yd6heJ/aSA/qVSYb68FAAe6w6I.9oji3WmSO", "email@gmail.com", rolesRepository.getById(1L)));
        userRepository.save(new User("user1", "$2y$12$oejcFX2l1bgRS1339yd6heJ/aSA/qVSYb68FAAe6w6I.9oji3WmSO", "email1@gmail.com",rolesRepository.getById(2L)));
        userRepository.save(new User("user2", "$2y$12$oejcFX2l1bgRS1339yd6heJ/aSA/qVSYb68FAAe6w6I.9oji3WmSO", "email2@gmail.com",rolesRepository.getById(3L)));

        //cart
        long i = 1;
        long ii = 2;
        long iii = 3;
        cartRepository.save(new Cart(productRepository.getById(i), userRepository.getById(i), 1));
        cartRepository.save(new Cart(productRepository.getById(ii), userRepository.getById(ii), 1));
        cartRepository.save(new Cart(productRepository.getById(ii), userRepository.getById(ii), 1));
        cartRepository.save(new Cart(productRepository.getById(ii), userRepository.getById(ii), 1));
        cartRepository.save(new Cart(productRepository.getById(iii), userRepository.getById(iii), 1));

    }

}
