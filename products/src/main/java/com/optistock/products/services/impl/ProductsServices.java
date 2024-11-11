package com.optistock.products.services.impl;


import com.optistock.products.converters.ProductsConverter;
import com.optistock.products.dtos.ProductsEntryDTO;
import com.optistock.products.dtos.ProductsExitDTO;
import com.optistock.products.models.Products;
import com.optistock.products.repository.ProductsRepository;
import com.optistock.products.services.IUProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProductsServices implements IUProductsServices {

    @Autowired

    ProductsRepository productsRepository;

    @Autowired
    ProductsConverter productsConverter;

    @Autowired

    @GetMapping
    public List<ProductsEntryDTO> getAllProducts() {
        return service.getAllProducts();
    }



    @Override
    public void createProduct(ProductsEntryDTO productsDTO) {
        try {
            Products products = productsConverter.productsEntryDTOToProduct(productsDTO);
            productsRepository.saveIfNotExists(products);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductsExitDTO updateUser(ProductsEntryDTO productsEntryDTO) {
        try {
            Products products = productsRepository.findByNameOrException(productsEntryDTO.getNombre());
            productsConverter.productsEntryDTOToProduct(productsEntryDTO);
            ProductsRepository.save(products);
            ProductsExitDTO productsExitDTO = ProductsConverter.productstoExit(products);
            return productsExitDTO;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(String Id) {
        productsConverter.findByIdOrException(idProducto);
        deleteProduct(idProducto);

    }
}
