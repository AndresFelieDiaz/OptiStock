package com.optistock.products.controllers;

import com.optistock.products.dtos.ProductsEntryDTO;
import com.optistock.products.dtos.ProductsExitDTO;
import com.optistock.products.models.Products;

import java.util.List;


public interface IUProductsController {

public List<Products> getAllProducts();

public void createProduct(ProductsEntryDTO productsDTO);

public ProductsExitDTO updateProduct(ProductsEntryDTO productsEntryDTO);

public void deleteProduct(String IdProduct);


}