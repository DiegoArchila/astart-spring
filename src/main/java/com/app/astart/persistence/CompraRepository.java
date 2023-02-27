package com.app.astart.persistence;

import com.app.astart.domain.Purchase;
import com.app.astart.domain.repository.PurchaseRepository;
import com.app.astart.persistence.crud.CompraCrudRepository;
import com.app.astart.persistence.entity.Compra;
import com.app.astart.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compra;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compra.findAll());
    }

    @Override
    public Optional<Purchase> getById(Integer purchaseId) {
        //return  (Optional<Purchase>) getPurchaseById(purchaseId);
        Optional<Purchase> purchase;
        purchase = compra.findById(purchaseId).map(compra1 -> mapper.toPurchase(compra1));
        return purchase;

    }

    @Override
    public Optional<List<Purchase>> getByIdClient(String clientId) {
        return compra.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra1 = mapper.toCompra(purchase);
        compra1.getProductos().forEach(comprasProducto -> comprasProducto.setCompra(compra1));
        return mapper.toPurchase(compra.save(compra1));
    }
}
