package com.example.SpringProductServiceProject.service;

import com.example.SpringProductServiceProject.Dto.FakeStoreCategoryDto;
import com.example.SpringProductServiceProject.Dto.FakeStoreProductDto;
import com.example.SpringProductServiceProject.Dto.UpdateProductRequestDto;
import com.example.SpringProductServiceProject.model.Category;
import com.example.SpringProductServiceProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
       FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+productId,
               FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {

        //list is generic class hence it will have issue hence need to create array
        FakeStoreProductDto[] fakeStoreProductDtos=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        List<Product> pr = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos)
        {
            pr.add(fakeStoreProductDto.toProduct());
        }
        return pr;
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
           FakeStoreProductDto response = restTemplate.postForObject(
                    "https://fakestoreapi.com/products",
                    fakeStoreProductDto,
                    FakeStoreProductDto.class
            );
        return response.toProduct();
    }

    @Override
    public String deleteProduct(Long productId) {
         try {
             restTemplate.delete(
                     "https://fakestoreapi.com/products/" + productId,
                     FakeStoreProductDto.class
             );
         }catch (Exception ex)
         {
             ex.printStackTrace();
         }
         return "product succefsully deleted";
    }

    @Override
    public Product deleteProductv2(Long productId) {

        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDto.class
        );
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product updateProduct(Long productId,UpdateProductRequestDto updateProductRequestDto) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(updateProductRequestDto.getId());
        fakeStoreProductDto.setTitle(updateProductRequestDto.getTitle());
        fakeStoreProductDto.setCategory(updateProductRequestDto.getCategory());
        fakeStoreProductDto.setPrice(updateProductRequestDto.getPrice());
        fakeStoreProductDto.setDescription(updateProductRequestDto.getDescription());
        fakeStoreProductDto.setImage(updateProductRequestDto.getImage());
           restTemplate.put(
                   "https://fakestoreapi.com/products/"+productId,
                   fakeStoreProductDto,
                   FakeStoreProductDto.class

           );
           return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProductsBycategory(String category) {

      FakeStoreProductDto[] fakeStoreProductDtos=  restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category,
               FakeStoreProductDto[].class
                );
      List<Product> pr = new ArrayList<>();

      for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos)
      {
          pr.add(fakeStoreProductDto.toProduct());
      }
      return pr;
    }

    @Override
    public List<Category> getAllCategories() {
        FakeStoreCategoryDto[] fakeStoreCategoryDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products/categories",
                        FakeStoreCategoryDto[].class);
        List<Category> ct = new ArrayList<>();
        for(FakeStoreCategoryDto fakeStoreCategoryDto:fakeStoreCategoryDtos)
        {
            ct.add(fakeStoreCategoryDto.categoryMapper());
        }
        return ct;
    }


}
