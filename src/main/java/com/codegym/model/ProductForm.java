package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import java.util.Date;

public class ProductForm {
    private Long id;
    private String name;
    private String price;
    private MultipartFile image;
    private Date date;




    @ManyToOne
    private Category category;

    public ProductForm() {
    }

    public ProductForm(Long id, String name, String price, MultipartFile image, Date date, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
