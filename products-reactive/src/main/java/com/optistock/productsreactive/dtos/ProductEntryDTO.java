package com.optistock.productsreactive.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntryDTO implements Serializable {

    public String   name;
    public String   category;
    public String   brand;
    public Integer  quantity;
    public Float    price;
    public Date     entryDate;
    public Date     expirationDate;
    public String   status;
    public Date     modificationDate;


}
