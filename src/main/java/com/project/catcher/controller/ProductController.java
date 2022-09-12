package com.project.catcher.controller;

import com.project.catcher.dto.ProductRequest.ProductCreateDto;
import com.project.catcher.dto.ProductRequest.ProductUpdateDto;
import com.project.catcher.dto.ProductResponse.ProductGetDto;
import com.project.catcher.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  public ProductGetDto getProduct(@PathVariable Long id) {

    ProductGetDto productDto = productService.getProduct(id);

    return productDto;
  }

  @GetMapping("/")
  public List<ProductGetDto> getProductList() {

    List<ProductGetDto> productGetDtoList = productService.getProductList();

    return productGetDtoList;
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  public Long createProduct(
      @RequestPart(value="request") ProductCreateDto dto,
      @RequestPart(value="images",required = false) List<MultipartFile> productImgs) {

    Long productId = productService.createProduct(dto,productImgs);

    return productId;

  }
  @PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  public Long updateProduct(
      @PathVariable Long id,
      @RequestPart(value="request") ProductUpdateDto dto,
      @RequestPart(value="images",required = false) List<MultipartFile> productImgs
  ) {

    Long productId = productService.updateProduct(id,dto,productImgs);

    return productId;
  }
  @DeleteMapping("/{id}")
  public Long deleteProduct(@PathVariable Long id) {

    Long productId = productService.deleteProduct(id);

    return productId;

  }

}
