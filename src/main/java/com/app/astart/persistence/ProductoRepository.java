package com.app.astart.persistence;

import com.app.astart.domain.Product;
import com.app.astart.domain.repository.ProductRepository;
import com.app.astart.persistence.crud.ProductoCrudRepository;
import com.app.astart.persistence.entity.Producto;
import com.app.astart.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.lang.Integer;
import java.lang.Boolean;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Integer categoryId) {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        Optional<List<Producto>> escasos;
        escasos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return escasos.map(esc -> mapper.toProducts(esc));
    }

    @Override
    public Optional<Product> getProduct(Integer productId) {
        return productoCrudRepository.findById(productId).map(prd -> mapper.toProduct(prd));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public Boolean delete(Integer idProduct) {
       return getProduct(idProduct).map(prd -> {
            productoCrudRepository.deleteById(idProduct);
            return !(productoCrudRepository.findById(idProduct).isPresent());
           //return true;
            }).orElse(false);
    }

}
