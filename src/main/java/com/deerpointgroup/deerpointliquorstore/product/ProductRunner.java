package com.deerpointgroup.deerpointliquorstore.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner implements CommandLineRunner{

@Autowired
private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("Kim Crowford", "A sauvignon blanc, passion fruit, gooseberry, bursting with flavour. ", 2, 19.99));
        productRepository.save(new Product("Longshot", "A cabernet sauvignon, Californian wine rich with flavour and ruby in color. ", 1, 16.99));
        productRepository.save(new Product("Beringer", "A cabernet sauvignon, dark fruit, chocolar and spice flavours with a hint of vanilla. ", 3, 9.99));
        productRepository.save(new Product("Terermana", "A smooth tequilla, notes of bright citrus with a fresh finish ", 5, 26.99));
        productRepository.save(new Product("Pink Whitney", "Vodka infused with fresh pink lemonade, creating a balance of sweetness and refreshing taste", 8, 29.99));
    }
    
    
    
}
