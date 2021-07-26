package com.deerpointgroup.deerpointliquorstore.order;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.user.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private long orderID;


    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;


    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    private int quantity;

    @Column(unique = true)
    private String orderCode;

    public Orders(){}

    public Orders(User user, Product product, int quantity){
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderCode  = UUID.randomUUID().toString().substring(0,6);
    }


    public String getUser() {
        return user.getUsername();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrderCode(){return orderCode;};




}