package com.deerpointgroup.deerpointliquorstore.cart;

import com.deerpointgroup.deerpointliquorstore.product.Product;
import com.deerpointgroup.deerpointliquorstore.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Cart {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private long cartID;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    private int quantity;

    public Cart(Product product, User user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }

    public Cart() {
    }

    public Cart(long cartID, Product product, User user, int quantity) {
        this.cartID = cartID;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }

    public long getCartID() {
        return cartID;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", product=" + product +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }


}
