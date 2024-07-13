package com.example.SpringProductServiceProject.Dto;

import com.example.SpringProductServiceProject.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreCategoryDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category categoryMapper()
    {
        Category category = new Category();
        category.setTitle(this.name);
        return category;
    }
}
