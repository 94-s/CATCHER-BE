package com.project.catcher.repository;

import com.project.catcher.entity.ProductCategory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

  @Override
  Optional<ProductCategory> findById(Long id);
}
