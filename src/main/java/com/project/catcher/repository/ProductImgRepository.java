package com.project.catcher.repository;

import com.project.catcher.entity.Product;
import com.project.catcher.entity.ProductImg;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImgRepository extends JpaRepository<ProductImg,Long> {

  @Override
  Optional<ProductImg> findById(Long id);

  List<ProductImg> findAllByProductId(Product product);

  List<ProductImg> findAllByProductIdAndIsDeleteFalse(Product product);


}
