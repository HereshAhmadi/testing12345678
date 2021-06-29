package com.deerpointgroup.deerpointliquorstore.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private long productID;
    private String productName;
    private String productDescription;
    //private String productCategory;
    private int productQuantity;
    private double productPrice;
    private double productDiscount;
    private int quantitySold;
    private boolean featuredProduct;
    
    public Product(){
    }

    public Product(int productID, String productName, String productDescription, int productQuantity, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        productDiscount = 0;
        quantitySold = 0;
        featuredProduct = false;
    }

    public Product(String productName, String productDescription, int productQuantity, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        productDiscount = 0;
        quantitySold = 0;
        featuredProduct = false;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public boolean isFeaturedProduct() {
        return featuredProduct;
    }

    public void setFeaturedProduct(boolean featuredProduct) {
        this.featuredProduct = featuredProduct;
    }
    
    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName +  ",productDescription" + productDescription +", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", productDiscount=" + productDiscount + ", featuredProduct=" + featuredProduct +'}';
    }
}
