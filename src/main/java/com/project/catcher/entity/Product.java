package com.project.catcher.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
public class Product extends BaseTimeEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(name = "is_delete", nullable = false)
  @ColumnDefault("False")
  private Boolean isDelete;

  @Column(name = "renew_at")
  private LocalDateTime renewAt;

  @Column(name = "hits", nullable = false)
  private Long hits;

  @ManyToOne
  @JoinColumn(name = "create_by")
  private Member createBy;

  @ManyToOne
  @JoinColumn(name = "update_by")
  private Member updateBy;

  @ManyToOne
  @JoinColumn(name = "product_category_id")
  private ProductCategory productCategoryId;

  //brand_id 작업 필요
//  @ManyToOne
//  @Column(name = "brand_id",nullable = false)
//  private Brand brandId;


}
