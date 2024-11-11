package com.optistock.productsreactive.services.impl;


import com.optistock.productsreactive.converters.ProductConverter;
import com.optistock.productsreactive.domain.model.Product;
import com.optistock.productsreactive.dtos.ProductExitDTO;
import com.optistock.productsreactive.domain.repository.ProductsReactiveRepository;
import com.optistock.productsreactive.services.IProductsReactiveServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductsReactiveServices implements IProductsReactiveServices {

    @Autowired
    ProductsReactiveRepository productsReactiveRepository;

    @Autowired
    ProductConverter productConverter;


    @Override
    public Flux<ProductExitDTO> getProductsByFilters(String brand, String category) {
        try{
            Flux<Product> products =  productsReactiveRepository.findByBrandOrCategory(brand, category);
            return productConverter.toExitDTOFlux(products);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flux<ProductExitDTO> getProductsToOutOfStock() {
        try{
            Flux<Product>  products =  productsReactiveRepository.findByQuantityLessThan(3);
            return productConverter.toExitDTOFlux(products);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flux<ProductExitDTO> getProductsOutOfStock() {
        try{
            Flux<Product>  products =  productsReactiveRepository.findByQuantity(0);
            return productConverter.toExitDTOFlux(products);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
