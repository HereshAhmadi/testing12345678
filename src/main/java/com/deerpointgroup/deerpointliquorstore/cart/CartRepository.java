package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

     List<Cart> findByUser(User user);

}
