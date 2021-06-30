package com.deerpointgroup.deerpointliquorstore.product;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getProductName());

        if (productOptional.isPresent()) {
            throw new IllegalStateException("Product already in database");
        } else {
            productRepository.save(product);
        }
    }

    public void deleteProduct(long productId) {
        boolean exists = productRepository.existsById(productId);

        if (!exists) {
            throw new IllegalStateException("Product with id" + productId + " does not exist");
        }

        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(long productId, String name, String productDescription, int productQuantity, double productPrice, double productDiscount) {
        boolean exists = productRepository.existsById(productId);

        if (!exists) {
            throw new IllegalStateException("Product with " + productId + " does not exists");
        }

        Product product = productRepository.getById(productId);

        if (name != null & name.equals(" ") && !Objects.equals(product.getProductName(), name)) {
            product.setProductName(name);
        }

        if (name != null & name.equals(" ") && !Objects.equals(product.getProductName(), name)) {

            Optional<Product> productOptional = productRepository.findProductByName(name);

            if (productOptional.isPresent()) {
                throw new IllegalStateException("Product already exists in the database");
            }
            product.setProductName(name);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getMostSoldProducts() {
        return productRepository.findMostSoldProducts();
    }

    public List<Product> getOnSaleProducts() {
        return productRepository.findOnSaleProducts();
    }

    public List<Product> getFeaturedProducts() {
        return productRepository.findFeaturedProducts();
    }

    public List<Product> searchProducts(String name) {
        return productRepository.searchProducts(name);
    }

}
