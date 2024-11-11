package com.optistock.products.services;


import com.optistock.products.dtos.ProductsEntryDTO;
import com.optistock.products.dtos.ProductsExitDTO;
import com.optistock.products.models.Products;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IUProductsServices {

   public default List<Products> getProducts(){
       return repository.findAll();
   }

   public void createProduct(ProductsEntryDTO productsDTO);

   public ProductsExitDTO updateProduct(ProductsEntryDTO productsEntryDTO);

   public void deleteProduct(String Id);



}
