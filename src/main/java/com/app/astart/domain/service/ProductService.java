package com.app.astart.domain.service;

import com.app.astart.domain.Product;
import com.app.astart.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.lang.Integer;
import java.lang.Boolean;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return (List<Product>) productRepository.getAll();
    }

    public Optional<Product> getProduct(int produtId){
        return (Optional<Product>) productRepository.getProduct(produtId);
    }

    public Optional<List<Product>> getProductsByCategory(int categoryId){
        return (Optional<List<Product>>) productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return (Optional<List<Product>>) productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Boolean delete(Integer idProduct) {
       return productRepository.delete(idProduct);
    }
}

