package com.optistock.products.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductsEntryDTO  implements Serializable {


    public String nombre;
    public String categoria;
    public String marca;
    public Integer cantidad;
    public float precio;
    public Date fecha_ingreso;
    public Date fecha_caducidad;
    public String estado;
    public Date fecha_de_modificacion;


}
