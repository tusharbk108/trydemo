package com.example.CategoryCrudOperation.Service;

import com.example.CategoryCrudOperation.Model.Category;
import com.example.CategoryCrudOperation.Repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(String page) {
    return categoryRepository.findAllByPage(page);
    }

    public Map<String, String> createNewCategories(Category category) {
    Map<String,String > respose = new HashMap<>();
    categoryRepository.save(category);
    respose.put("Status","Success");
    return respose;
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategoryById(int id,Category oldCategory) {
        Category Category = categoryRepository.findById(id).orElse(null);
        Category.setCategoryid(oldCategory.getCategoryid());
        Category.setCategoryname(oldCategory.getCategoryname());
        Category.setCategorytype(oldCategory.getCategorytype());
        Category.setPage(oldCategory.getPage());

        return categoryRepository.save(Category);
    }

    public Map<String, String> deleteCategoryById(int id) {
        Map<String,String > respose = new HashMap<>();
        categoryRepository.deleteById(id);
        respose.put("Status","Success");
        return respose;
    }
}
