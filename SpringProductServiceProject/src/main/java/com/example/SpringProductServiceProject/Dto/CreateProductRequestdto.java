package com.example.SpringProductServiceProject.Dto;

public class CreateProductRequestdto {

    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
    //dto for each request so that in future
    //if request needs any additional parameters
    //we can easily add without impacting anything
    //else.
}
