package com.project.catcher.entity;

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
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class ProductImg extends BaseTimeEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Product_img_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product productId;

  @Column(name = "img_url", nullable = false, length = 512)
  private String imgUrl;

  @Column(name = "is_delete", nullable = false)
  @ColumnDefault("False")
  private Boolean isDelete;

  protected ProductImg() {
  }

  public void delete() {
    this.isDelete = true;
  }

}
