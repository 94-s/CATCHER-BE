package com.project.catcher.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductResponseDto {


  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ProductGetDto {

    // 상품 정보
    Long id;
    String name;
    String description;
    Integer price;
    Long hits;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    String category;
    List<String> productImgs;
    String brand;

    // 상품 게시자 정보
    String nickname;
    String profileImg;

    @Override
    public String toString() {
      return "ProductGetDto{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", description='" + description + '\'' +
          ", price=" + price +
          ", hits=" + hits +
          ", createAt=" + createAt +
          ", updateAt=" + updateAt +
          ", category='" + category + '\'' +
          ", productImgs=" + productImgs +
          ", brand='" + brand + '\'' +
          ", nickname='" + nickname + '\'' +
          ", profileImg='" + profileImg + '\'' +
          '}';
    }
  }


}
