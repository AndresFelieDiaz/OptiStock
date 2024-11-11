package com.optistock.productsreactive.domain.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "productsreactive")
public class Product {

    @Id
    private String  idProduct;
    public String   category;
    public String   brand;
    public Integer  quantity;
    public Float    price;
    public Date     entryDate;
    public Date     expirationDate;
    public String   status;
    public Date     modificationDate;

}
