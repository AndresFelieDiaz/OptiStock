package com.optistock.products.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document
public class Products {


    @Id
    private String idProduct;
    private String nombre;
    private String categoria;
    private String marca;
    private Integer cantidad;
    private float precio;
    private Date fecha_ingreso;
    private Date fecha_caducidad;
    private String estado;
    private Date fecha_de_modificacion;

}
