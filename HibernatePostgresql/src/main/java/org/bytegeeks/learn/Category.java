package org.bytegeeks.learn;

import java.util.HashSet;
import java.util.Set;

public class Category implements java.io.Serializable{

    private Integer id;
    private String name;
    private Set<Product> productDetails = new HashSet<Product>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProductDetails() {
        return productDetails;
    }

    public void setProductDetail(Set<Product> productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", productDetails=" + productDetails + "]";
    }


}
