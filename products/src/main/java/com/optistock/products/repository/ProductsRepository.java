package com.optistock.products.repository;

import com.optistock.products.models.Products;
import org.springframework.data.domain.Example;

import java.util.Optional;

public interface ProductsRepository extends BaseMongoRepository<Products, String> {
    @Override
    Optional<Products> findById(String id);

    Optional<Products> findByProductName(String productName);

    default Products findByNameOrException(String name){
        return findByElementOrThrow(findByName(name), "Producto ",name );
    }

    default Products findByIdOrException(String idProduct)
    { return findByElementOrThrow(findById(idProduct), "Producto ",idProduct );}

   default Products saveIfnoExists(Products product){


    }

}
