package com.example.SpringProductServiceProject.Dto;

public class UpdateProductRequestDto {

    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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
}
