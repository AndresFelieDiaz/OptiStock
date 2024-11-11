package com.optistock.productsreactive.converters;

import com.optistock.productsreactive.dtos.ProductExitDTO;
import com.optistock.productsreactive.domain.model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductConverter {

    public Mono<ProductExitDTO> productToProductExit(Product product) {
        return Mono.just(
                ProductExitDTO.builder()
                        .brand(product.getBrand())
                        .category(product.getCategory())
                        .entryDate(product.getEntryDate())
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .expirationDate(product.getExpirationDate())
                        .status(product.getStatus())
                        .modificationDate(product.getModificationDate())
                        .build()
        );
    }


    public Flux<ProductExitDTO> toExitDTOFlux(Flux<Product> products) {
        return products.flatMap(this::productToProductExit);
    }

}
