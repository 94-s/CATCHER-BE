package com.project.catcher.dto;

import com.project.catcher.entity.Brand;
import com.project.catcher.entity.Product;
import com.project.catcher.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductRequestDto {

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
      Product product = Product.builder().name(name).description(description).price(price)
          .brandId(brand)
          .productCategoryId(productCategory).build();
//      Product product = new Product(name,description,price,productCategory,brand);
      product.setCreatedBy(1L);
      return product;
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
