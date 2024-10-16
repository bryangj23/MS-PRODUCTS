package com.prodigio.products.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestModel {
    private  Integer productiId;
    private  String productName;
    private String productDescription;
    private Integer categoryId;
    private Boolean enabled;
    private Date createdAt;
    private String createdBy;
}
