package com.optistock.productsreactive.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductExitDTO implements Serializable {

    public String   idProduct;
    public String   name;
    public String   category;
    public String   brand;

    @NotNull(message = "Quantity cannot be null")
    @Positive
    public Integer  quantity;
    public Float    price;
    public Date     entryDate;
    public Date     expirationDate;
    public String   status;
    public Date     modificationDate;
}
