package com.project.catcher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class ProductImg {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Product_img_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product productId;

  @Column(name = "img_url", nullable = false)
  private String imgUrl;

}
