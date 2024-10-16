package com.prodigio.products.service;

import com.prodigio.products.model.ProductRequestModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    void createProduct(ProductRequestModel product);
    List<ProductRequestModel> getProductsAll();
}
