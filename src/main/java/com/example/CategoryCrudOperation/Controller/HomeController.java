package com.example.CategoryCrudOperation.Controller;

import com.example.CategoryCrudOperation.Model.Category;
import com.example.CategoryCrudOperation.Model.Product;
import com.example.CategoryCrudOperation.Repo.ProductRepository;
import com.example.CategoryCrudOperation.Service.CategoryService;
import com.example.CategoryCrudOperation.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(@RequestParam String page){
      return categoryService.getAllCategories(page);
    }

    @PostMapping("/categories")
    public Map<String,String> createNewCategories(@RequestBody Category category){
        return categoryService.createNewCategories(category);
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategoryById(@PathVariable int id,@RequestBody Category category){
        return categoryService.updateCategoryById(id,category);
    }

    @DeleteMapping("/categories/{id}")
    public Map<String,String>  deleteCategoryById(@PathVariable int id){
        return categoryService.deleteCategoryById(id);
    }

    //product API

    @GetMapping("/product")
    public List<Product> getAllProduct(@RequestParam String page){
        return productService.getAllProduct(page);
    }

    @PostMapping("/product")
    public Map<String,String> createNewProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PutMapping("/product/{id}")
    public Product updateProductById(@PathVariable int id,@RequestBody Product product){
        return productService.updateProductById(id,product);
    }

    @DeleteMapping("/product/{id}")
    public Map<String,String> deleteProductById(@PathVariable int id){
        return productService.deleteProductById(id);
    }
}
