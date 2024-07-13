package com.example.SpringProductServiceProject.controller;

import com.example.SpringProductServiceProject.Dto.CreateProductRequestdto;
import com.example.SpringProductServiceProject.Dto.UpdateProductRequestDto;
import com.example.SpringProductServiceProject.Exception.ProductNotFoundException;
import com.example.SpringProductServiceProject.model.Category;
import com.example.SpringProductServiceProject.model.Product;
import com.example.SpringProductServiceProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestdto createProductRequestdto){
        return productService.createProduct(
                createProductRequestdto.getTitle(),
                createProductRequestdto.getDescription(),
                createProductRequestdto.getCategory(),
                createProductRequestdto.getPrice(),
                createProductRequestdto.getImage()
        );

    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
     return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) throws ProductNotFoundException {
        //if(productService.getSingleProduct(productId)==null)
             new ProductNotFoundException("Not available");
      return productService.getSingleProduct(productId);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getBySpecificCategory(@PathVariable String category)
    {
        return productService.getAllProductsBycategory(category);
    }
    @DeleteMapping("/products/{id}")
    public String  deleteProduct(@PathVariable("id")Long id){
        String result = productService.deleteProduct(id);
        //if(result.equals("product succefsully deleted"))
            return "Done";
    }

    @DeleteMapping("/products/v2/{id}")
    public Product deleteProductv2(@PathVariable("id")Long id)
    {
        return  productService.deleteProductv2(id);
    }
     @PutMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable("id")Long id,@RequestBody UpdateProductRequestDto updateProductRequestDto)
     {
          return productService.updateProduct(id,updateProductRequestDto);
     }

     @GetMapping("/products/categories")
    public List<Category> getCategories(){
    return productService.getAllCategories();
     }
}
