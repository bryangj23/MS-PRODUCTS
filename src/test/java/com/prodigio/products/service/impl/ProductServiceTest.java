package com.prodigio.products.service.impl;

import com.prodigio.products.entity.Category;
import com.prodigio.products.entity.Product;
import com.prodigio.products.model.ProductRequestModel;
import com.prodigio.products.repository.ICategoryRepository;
import com.prodigio.products.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private ICategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private Category category;
    private ProductRequestModel productRequestModel;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        category = Category.builder().categoryId(1)
                .categoryName("Tecnologia")
                .categoryDescription("")
                .enable(true)
                .createAt(new Date())
                .build();

        product = Product.builder()
                .productName("Portatil HP")
                .productDescription("550 SDD, 16 G RAM")
                .categoryId(category)
                .enabled(true)
                .createdAt(new Date())
                .createdBy("brayan.guardo")
                .build();

        productRequestModel = ProductRequestModel.builder()
                .productName("Portatil HP")
                .productDescription("550 SDD, 16 G RAM")
                .categoryId(1)
                .enabled(true)
                .createdAt(new Date())
                .createdBy("brayan.guardo")
                .build();

    }

    @Test
    void createProduct() {
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        productService.createProduct(productRequestModel);
    }

    @Test
    void getProductsAll() {
        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
        assertFalse(productService.getProductsAll().isEmpty());
    }
}