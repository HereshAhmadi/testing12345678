package com.deerpointgroup.deerpointliquorstore.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class ProductController {
    

    private final ProductService productService;
    
    
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    
    
//    @PostMapping
//    public String registerNewCustomer( @RequestParam(required = true) String name,
//                                    @RequestParam(required = true) String password,
//                                    @RequestParam(required = true) String passwordRepeat,
//                                    @RequestParam(required = true) String email){
//        
//        if(password.equals(passwordRepeat)){
//            try{
//               customerService.addNewCustomer(new Customer(name, password, email)); 
//               return "Account Created";
//            }catch(Exception e){
//                return "Email already taken";
//            }
//            
//        }else{
//            return "Passwords do not match";
//        }
//        
//    }
//    
//    @DeleteMapping(path = "{customerId}")
//    public void deleteStudent(@PathVariable("customerId") Long customerId ){
//        customerService.deleteCustomer(customerId);
//    }
//    
//    //for updating
//    @PutMapping(path = "{customerId}")
//    public void updateStudent(@PathVariable("customerId") long customerId,
//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false) String email){
//        customerService.updateCustomer(customerId, name, email);
//    }
    
    
}
