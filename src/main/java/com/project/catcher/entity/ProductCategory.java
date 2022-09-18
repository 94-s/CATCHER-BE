package com.project.catcher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
public class ProductCategory{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_category_id")
  private Long id;

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "is_delete", nullable = false)
  @ColumnDefault("False")
  private Boolean isDelete;

  protected ProductCategory() {
  }

  public void delete() {
    this.isDelete = true;
  }

}
