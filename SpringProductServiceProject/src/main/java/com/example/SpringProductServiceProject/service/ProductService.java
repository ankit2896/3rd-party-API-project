package com.example.SpringProductServiceProject.service;

import com.example.SpringProductServiceProject.Dto.UpdateProductRequestDto;
import com.example.SpringProductServiceProject.model.Category;
import com.example.SpringProductServiceProject.model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getAllProducts();

    Product createProduct(String title,String description,String category
                           ,double price,String image);

    String deleteProduct(Long productId);

    Product deleteProductv2(Long productId);

    Product updateProduct(Long productId,UpdateProductRequestDto updateProductRequestDto);

    List<Product> getAllProductsBycategory(String category);

    List<Category> getAllCategories();
}
