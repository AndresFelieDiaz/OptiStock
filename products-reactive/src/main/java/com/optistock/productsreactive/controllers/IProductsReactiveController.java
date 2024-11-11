package com.optistock.productsreactive.controllers;


import com.optistock.productsreactive.dtos.ProductExitDTO;
import reactor.core.publisher.Flux;

public interface IProductsReactiveController {

    public Flux<ProductExitDTO>  getProductsByFilters (String category, String brand);

    public Flux<ProductExitDTO>  getProductsToOutOfStock();

    public Flux<ProductExitDTO>  getProductsOutOfStock();

}
