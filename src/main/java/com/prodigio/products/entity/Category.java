package com.prodigio.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@Data
@Table(name = "Categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @NonNull
    @Column(name = "name", length = 100, nullable = false)
    private String categoryName;

    @Column(name = "description", length = 255, nullable = true)
    private String categoryDescription;

    @NonNull
    @Column(name = "enabled", nullable = false)
    private Boolean enable;

    @NonNull
    @Column(name = "create_at", nullable = false)
    private Date createAt;
}
