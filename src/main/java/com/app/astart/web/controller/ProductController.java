package com.app.astart.web.controller;

import com.app.astart.domain.Product;
import com.app.astart.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.lang.Integer;
import java.lang.Boolean;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService product;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(product.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer productId){
        return product.getProduct(productId)
                .map(prd -> new ResponseEntity<>(prd,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("id")Integer categoryId){

        return product.getProductsByCategory(categoryId)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/scarse")
    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        return product.getScarseProducts(quantity);
    }

    @PostMapping("/new")
    public ResponseEntity<Product> save(@RequestBody Product prd){

        return new ResponseEntity<>(product.save(prd),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer productId){
        return (product.delete(productId)) ?
              new ResponseEntity<>(product.delete(productId), HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
