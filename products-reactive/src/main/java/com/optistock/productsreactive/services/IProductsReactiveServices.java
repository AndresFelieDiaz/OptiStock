package com.optistock.productsreactive.services;

import com.optistock.productsreactive.dtos.ProductExitDTO;
import reactor.core.publisher.Flux;

public interface IProductsReactiveServices {

    public Flux<ProductExitDTO> getProductsByFilters (String category, String brand);

    public Flux<ProductExitDTO>  getProductsToOutOfStock();

    public Flux<ProductExitDTO>  getProductsOutOfStock();

}
