package com.deerpointgroup.deerpointliquorstore.product;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


interface ProductRepository extends JpaRepository<Product, Long>{
    @Query("SELECT s FROM Product s WHERE s.productName = ?1")
    Optional<Product> findProductByName(String name);
}
