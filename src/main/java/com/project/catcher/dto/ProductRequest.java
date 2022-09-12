package com.project.catcher.dto;

import com.project.catcher.entity.Brand;
import com.project.catcher.entity.Product;
import com.project.catcher.entity.ProductCategory;
import com.project.catcher.entity.ProductImg;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ProductCreateDto {

    // 상품 정보
    String name;
    String description;
    Integer price;

    Long categoryId;
    Long brandId;

    // 상품 게시자 정보
    Long memberId;

    public Product toProduct(Brand brand, ProductCategory productCategory){
      return Product.builder().name(name).description(description).price(price).brandId(brand)
          .productCategoryId(productCategory).build();
    }
  }

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ProductUpdateDto {

    // 상품 정보
    String name;
    String description;
    Integer price;

    Long categoryId;
    Long brandId;

    // 상품 게시자 정보
    Long memberId;
  }
}
