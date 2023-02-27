package com.app.astart.domain.repository;

import com.app.astart.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    /**
     * Lista todos los Productos
     * @return Regresa todos los productos almacenados en la DB
     */
    List<Product> getAll();

    /**
     * Lista los productos según su categoria ID
     * @param categoryId ID de la categoria la cual necesita buscar
     * @return Regresa la lista obtenida según el ID buscado.
     */
    Optional<List<Product>> getByCategory(Integer categoryId);

    Optional<List<Product>> getScarseProducts(Integer quantity);

    Optional<Product> getProduct(Integer productId);

    Product save(Product product);

    Boolean delete(Integer idProduct);

}
