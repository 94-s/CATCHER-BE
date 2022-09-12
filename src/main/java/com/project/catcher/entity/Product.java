package com.project.catcher.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Product extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "description", nullable = false, length = 2500)
  private String description;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(name = "is_delete", nullable = false)
  @ColumnDefault("False")
  private Boolean isDelete;

  @Column(name = "renew_at")
  private LocalDateTime renewAt;

  @Column(name = "hits", nullable = false)
  @ColumnDefault("0")
  private Long hits;

  @ManyToOne
  @JoinColumn(name = "product_category_id")
  private ProductCategory productCategoryId;

  //brand_id 작업 필요
  @ManyToOne
  @JoinColumn(name = "brand_id",nullable = false)
  private Brand brandId;

  protected Product() {
  }

  public void delete() {
    this.isDelete = true;
  }

  public void update(String name, String description, Integer price,
       ProductCategory productCategoryId,
      Brand brandId) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.productCategoryId = productCategoryId;
    this.brandId = brandId;
  }
}
