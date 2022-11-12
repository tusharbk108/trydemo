package com.example.CategoryCrudOperation.Repo;

import com.example.CategoryCrudOperation.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByPage(String page);
}
