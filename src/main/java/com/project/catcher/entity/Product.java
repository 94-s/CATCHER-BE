package com.project.catcher.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Builder
@DynamicInsert
@DynamicUpdate
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

  @Column(name = "is_delete")
  @ColumnDefault("false")
  private Boolean isDelete;

  @Column(name = "renew_at")
  private LocalDateTime renewAt;

  @Column(name = "hits", columnDefinition = "0L")
//  @ColumnDefault("0L")
  private Long hits;

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name = "product_category_id")
  private ProductCategory productCategoryId;

  //brand_id 작업 필요
  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name = "brand_id",nullable = false)
  private Brand brandId;

  protected Product() {
  }

  //  public static/
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

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", isDelete=" + isDelete +
        ", renewAt=" + renewAt +
        ", hits=" + hits +
        ", productCategoryId=" + productCategoryId +
        ", brandId=" + brandId +
        '}';
  }
}
