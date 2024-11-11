package com.optistock.productsreactive.controllers.impl;

import com.optistock.productsreactive.controllers.IProductsReactiveController;
import com.optistock.productsreactive.dtos.ProductExitDTO;
import com.optistock.productsreactive.services.IProductsReactiveServices;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@Controller
@RequestMapping("products-search")
@RequiredArgsConstructor
public class ProductsReactiveController implements IProductsReactiveController {

    @Autowired
    private IProductsReactiveServices iProductsReactiveServices;


    @Override
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductExitDTO>  getProductsByFilters(String category, String brand) {
        return iProductsReactiveServices.getProductsByFilters(category, brand);
    }

    @Override
    @GetMapping("/tooutofstock")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductExitDTO>  getProductsToOutOfStock() {
        return iProductsReactiveServices.getProductsToOutOfStock();
    }

    @Override
    @GetMapping("outofstock")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductExitDTO> getProductsOutOfStock() {
        return iProductsReactiveServices.getProductsOutOfStock();
    }
}
