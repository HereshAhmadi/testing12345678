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

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    
    
    public void addNewCustomer(Customer customer){
       Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
       
       if(customerOptional.isPresent()){
           throw new IllegalStateException("Email taken");
       }else{
           customerRepository.save(customer);
       }
     }
    
    
    
    public void deleteCustomer(long customerId){
        boolean exists = customerRepository.existsById(customerId);
        
       if(!exists){
           throw new IllegalStateException("Customer with id" + customerId + " does not exist");
       }
       
       customerRepository.deleteById(customerId);
    }
    
    
    @Transactional
    public void updateCustomer(long customerId, String name, String email){
        boolean exists = customerRepository.existsById(customerId);
        
        if(!exists){
            throw new IllegalStateException("Customer with " + customerId +" does not exists");
        }
        
        Customer customer = customerRepository.getById(customerId);
        
        if(name != null & name.equals(" ") && !Objects.equals(customer.getName(), name)){
           customer.setName(name); 
        }
        
        if(email != null & email.equals(" ") && !Objects.equals(customer.getEmail(), email)){
            
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            
                if(customerOptional.isPresent()){
                    throw new IllegalStateException("Email taken");
                }
            customer.setEmail(email);
        }
    }
}