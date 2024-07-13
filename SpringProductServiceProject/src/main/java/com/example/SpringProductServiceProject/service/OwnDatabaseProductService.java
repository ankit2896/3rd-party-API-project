package com.example.SpringProductServiceProject.service;

import com.example.SpringProductServiceProject.Dto.UpdateProductRequestDto;
import com.example.SpringProductServiceProject.model.Category;
import com.example.SpringProductServiceProject.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OwnDatabaseProductService")
public class OwnDatabaseProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

    @Override
    public Product deleteProductv2(Long productId) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, UpdateProductRequestDto updateProductRequestDto) {
        return null;
    }

    @Override
    public List<Product> getAllProductsBycategory(String category) {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

}
