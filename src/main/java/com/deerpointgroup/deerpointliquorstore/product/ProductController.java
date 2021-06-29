package com.deerpointgroup.deerpointliquorstore.product;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/mostsold", method = RequestMethod.GET)
    public List<Product> getMostSoldItems() {
        return productService.getMostSoldProducts();
    }
    
    @RequestMapping(value = "/on-sale", method = RequestMethod.GET)
    public List<Product> getOnSaleItems() {
        return productService.getOnSaleProducts();
    }
    
    @RequestMapping(value = "/featured", method = RequestMethod.GET)
    public List<Product> getFeaturedItems() {
        return productService.getFeaturedProducts();
    }

    

    @PostMapping
    public String newProduct(@RequestParam(required = true) String productName,
            @RequestParam(required = true) String productDescription,
            @RequestParam(required = true) int productQuantity,
            @RequestParam(required = true) double productPrice,
            @RequestParam(required = true) double productDiscount) {

        if (productName != null && productName.length() > 0) {
            try {
                productService.addNewProduct(new Product(productName, productDescription, productQuantity, productPrice));
                return "Product Added";
            } catch (Exception e) {
                return "Product ID already used";
            }

        } else {
            return "Passwords do not match";
        }

    }

    //Deleting a product
    @DeleteMapping(path = "{productID}")
    public void deleteProduct(@PathVariable("productID") int productID) {
        productService.deleteProduct(productID);
    }

    //for updating
    @PutMapping(path = "{productID}")
    public void updateProduct(@PathVariable("productID") int productID,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String productDescription,
            @RequestParam(required = false) int productQuantity,
            @RequestParam(required = false) double productPrice,
            @RequestParam(required = false) double productDiscount) {
        productService.updateProduct(productID, productName, productDescription, productQuantity, productPrice, productDiscount);
    }

}
