package com.optistock.productsreactive.domain.repository;

import com.optistock.productsreactive.domain.model.Product;
import com.optistock.productsreactive.dtos.ProductExitDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.LinkedList;

public interface ProductsReactiveRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findByQuantityLessThan(Integer quantity);

    Flux<Product>  findByQuantity(Integer quantity);

    Flux<Product>  findByBrandOrCategory( String brand, String category);

}
