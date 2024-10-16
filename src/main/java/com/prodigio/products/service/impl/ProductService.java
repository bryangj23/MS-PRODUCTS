package com.prodigio.products.service.impl;

import com.prodigio.products.entity.Category;
import com.prodigio.products.entity.Product;
import com.prodigio.products.exception.GlobalCustomException;
import com.prodigio.products.exception.GlobalExceptionHandler;
import com.prodigio.products.model.ProductRequestModel;
import com.prodigio.products.repository.ICategoryRepository;
import com.prodigio.products.repository.IProductRepository;
import com.prodigio.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void createProduct(ProductRequestModel product) {

        Optional<Category> category = categoryRepository.findById(product.getCategoryId());

        if (category.isEmpty()) {
            throw new GlobalCustomException("No Existe Categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        productRepository.save(Product.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .categoryId(category.get())
                .enabled(true)
                .createdAt(new Date())
                .createdBy(product.getCreatedBy())
                .build());

    }

    @Override
    public List<ProductRequestModel> getProductsAll() {
        return productRepository.findAll().stream().map(x -> {
            return ProductRequestModel.builder()
                    .productiId(x.getProductiId())
                    .productName(x.getProductName())
                    .productDescription(x.getProductDescription())
                    .enabled(x.getEnabled())
                    .createdAt(x.getCreatedAt())
                    .createdBy(x.getCreatedBy())
                    .build();
        }).collect(Collectors.toList());
    }
}
