package org.bytegeeks.learn;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Model class for Product
 */

public class Product implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String code;
    private String name;
    private BigDecimal price;
    private Category category ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", code=" + code + ", name=" + name + ", price=" + price + ", categories="
                + category + "]";
    }


}