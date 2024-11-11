package com.optistock.products.controllers.impl;


import com.optistock.products.controllers.IUProductsController;
import com.optistock.products.dtos.ProductsEntryDTO;
import com.optistock.products.dtos.ProductsExitDTO;
import com.optistock.products.models.Products;
import com.optistock.products.services.IUProductsServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class ProductsController implements IUProductsController {
    private final IUProductsServices iuProductsServices;

    public ProductsController(IUProductsServices iuProductsServices) {this.iuProductsServices = iuProductsServices;}


    @Override
    @GetMapping

    public List<Products> getAllProducts() {
        return service.getallProducts();
    }

    @Override
    @PostMapping
    public void createProduct(ProductsEntryDTO productsDTO) { iuProductsServices.createProduct(productsDTO); }


    }

    @Override
    @PutMapping
    public ProductsExitDTO updateProduct(ProductsEntryDTO productsDTO) {
        return iuProductsServices.updateProduct(ProductsEntryDTO);}

    @Override
    public void deleteProduct(String IdProduct) { iuProductsServices.deleteProduct(idProduct);


    }
}
