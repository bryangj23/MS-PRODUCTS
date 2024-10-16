package com.prodigio.products.controller;

import com.prodigio.products.model.ProductRequestModel;
import com.prodigio.products.service.IProductService;
import com.prodigio.products.util.AppRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = AppRoutes.PRODUCT_ROUTE)
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductRequestModel>> getProducts() {
        return ResponseEntity.ok(productService.getProductsAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getCatalogById(
            @RequestBody ProductRequestModel product
    ) {
        productService.createProduct(product);
        return ResponseEntity.ok(HttpStatus.OK.getReasonPhrase());
    }
}
