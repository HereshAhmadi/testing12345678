package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


interface CartRepository extends JpaRepository<Cart, Long>{
    @Query("SELECT s FROM Cart s WHERE s.cartID = ?1")
    Optional<Product> findCartByID(Long cartID);
}
