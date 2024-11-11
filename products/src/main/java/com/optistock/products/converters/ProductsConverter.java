package com.optistock.products.converters;



import com.optistock.products.dtos.ProductsEntryDTO;
import com.optistock.products.dtos.ProductsExitDTO;
import com.optistock.products.models.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsConverter {

    public Products productsEntryDTOToProduct(ProductsEntryDTO productsEntryDTO) {
          try {
              Products products = new Products();
              products.setNombre(productsEntryDTO.getNombre());
              products.setCategoria(productsEntryDTO.getCategoria());
              products.setMarca(productsEntryDTO.getMarca());
              products.setCantidad(productsEntryDTO.getCantidad());
              products.setPrecio(productsEntryDTO.getPrecio());
              products.setFecha_ingreso(productsEntryDTO.getFecha_ingreso());
              products.setFecha_caducidad(productsEntryDTO.getFecha_caducidad());
              products.setEstado(productsEntryDTO.getEstado());
              products.setFecha_de_modificacion(productsEntryDTO.getFecha_de_modificacion());
              return products;
          }catch (Exception e) {
              throw new RuntimeException(e);
          }

    }
    public ProductsExitDTO productsToProductsExitDTO(Products products) {
        ProductsExitDTO productsExitDTO = new ProductsExitDTO();
        productsExitDTO.setIdProduct(products.getIdProduct());
        productsExitDTO.setNombre(products.getNombre());
        productsExitDTO.setCategoria(products.getCategoria());
        productsExitDTO.setMarca(products.getMarca());
        productsExitDTO.setCantidad(products.getCantidad());
        productsExitDTO.setPrecio(products.getPrecio());
        productsExitDTO.setFecha_ingreso(products.getFecha_ingreso());
        productsExitDTO.setFecha_caducidad(products.getFecha_caducidad());
        productsExitDTO.setEstado(products.getEstado());



        return productsExitDTO;
    }



}
