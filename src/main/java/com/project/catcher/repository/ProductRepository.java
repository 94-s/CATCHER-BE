package com.project.catcher.repository;

import com.project.catcher.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

  @Override
  Optional<Product> findById(Long id);

  @Override
  List<Product> findAll();
}
