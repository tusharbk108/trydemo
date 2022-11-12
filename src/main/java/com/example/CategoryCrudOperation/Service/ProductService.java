package com.example.CategoryCrudOperation.Service;

import com.example.CategoryCrudOperation.Model.Category;
import com.example.CategoryCrudOperation.Model.Product;
import com.example.CategoryCrudOperation.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(String page) {
        return productRepository.findAllByPage(page);
    }

    public Map<String, String> createNewProduct(Product product) {
        Map<String,String > respose = new HashMap<>();
        productRepository.save(product);
        respose.put("Status","Success");
        return respose;
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product updateProductById(int id, Product oldproduct) {
        Product product = productRepository.findById(id).orElse(null);
        product.setProductid(oldproduct.getProductid());
        product.setProductname(oldproduct.getProductname());
        product.setProducttype(oldproduct.getProducttype());
        product.setPage(oldproduct.getPage());

        return productRepository.save(product);
    }

    public Map<String, String> deleteProductById(int id) {
        Map<String,String > respose = new HashMap<>();
        productRepository.deleteById(id);
        respose.put("Status","Success");
        return respose;
    }
}
