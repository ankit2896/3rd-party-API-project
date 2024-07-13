package com.example.SpringProductServiceProject.Dto;

import com.example.SpringProductServiceProject.model.Category;
import com.example.SpringProductServiceProject.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product toProduct()
    {
        Product pr = new Product();
        pr.setId(id);
        pr.setTitle(title);
        pr.setImageUrl(image);
        pr.setDescription(description);
        Category category1 = new Category();
        category1.setTitle(category);
        pr.setCategory(category1);
        pr.setPrice(price);
        return pr;
    }
}
