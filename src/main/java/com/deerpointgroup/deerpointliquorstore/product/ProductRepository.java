package com.deerpointgroup.deerpointliquorstore.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long>{
    @Query("SELECT s FROM Product s WHERE s.productName = ?1")
    Optional<Product> findProductByName(String name);
    
    @Query(value = "SELECT * FROM Product ORDER BY quantity_sold", nativeQuery = true)
    List<Product> findMostSoldProducts();
    @Query(value = "SELECT * FROM Product ORDER BY product_discount", nativeQuery = true)
    List<Product> findOnSaleProducts();
    @Query(value = "SELECT * FROM Product WHERE featured_product = 1 ORDER BY featured_product DESC fetch first 5 rows only ", nativeQuery = true)
    List<Product> findFeaturedProducts();
//    @Query(value = "UPDATE Product SET featured_product = 1 WHERE productID = :input", nativeQuery = true)
//    Optional<Product> setProductFeatured(long id);

    Product findByProductID(long id);


    List<Product> findByProductNameContainingIgnoreCase(String name);
}
