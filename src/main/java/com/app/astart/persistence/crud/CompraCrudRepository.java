package com.app.astart.persistence.crud;

import com.app.astart.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String cliente);

    @Override
    Optional<Compra> findById(Integer integer);
    //Compra save(Compra compra);


    @Override
    Compra save(Compra compra);
}
