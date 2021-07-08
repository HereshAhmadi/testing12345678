package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {

}
