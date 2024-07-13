package com.example.SpringProductServiceProject.repository;

import com.example.SpringProductServiceProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByTitle(String title);
}
