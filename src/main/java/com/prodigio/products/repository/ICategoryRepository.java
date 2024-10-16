package com.prodigio.products.repository;

import com.prodigio.products.entity.Category;
import com.prodigio.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository  extends JpaRepository<Category, Integer>  {
}
