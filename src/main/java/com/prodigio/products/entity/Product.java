package com.prodigio.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@Data
@Table(name = "Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer productiId;

    @NonNull
    @Column(name = "name", length = 200, nullable = false)
    private  String productName;

    @Column(name = "description", length = 255, nullable = true)
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @NonNull
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @NonNull
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @NonNull
    @Column(name = "created_by", length = 50, nullable = false)
    private String createdBy;
}