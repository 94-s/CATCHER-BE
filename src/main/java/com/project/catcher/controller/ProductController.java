package com.project.catcher.controller;

import com.project.catcher.dto.ProductRequestDto.ProductCreateDto;
import com.project.catcher.dto.ProductRequestDto.ProductUpdateDto;
import com.project.catcher.dto.ProductResponseDto.ProductGetDto;
import com.project.catcher.service.ProductService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  public ResponseEntity<ProductGetDto> getProduct(@PathVariable Long id) {

    ProductGetDto productDto = productService.getProduct(id);

    return new ResponseEntity(productDto,HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<ProductGetDto>> getProductList() {

    List<ProductGetDto> productGetDtoList = productService.getProductList();

    return new ResponseEntity(productGetDtoList,HttpStatus.OK);
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<Long> createProduct(
      @RequestPart(value="productCreateDto") ProductCreateDto dto,
      @RequestPart(value="images",required = false) List<MultipartFile> productImgs) {

    Long productId = null;
    try {
      productId = productService.createProduct(dto,productImgs);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new ResponseEntity(productId,HttpStatus.OK);

  }
  @PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<Long> updateProduct(
      @PathVariable Long id,
      @RequestPart(value="productUpdateDto") ProductUpdateDto dto,
      @RequestPart(value="images",required = false) List<MultipartFile> productImgs
  ) {

    Long productId = null;
    try {
      productId = productService.updateProduct(id,dto,productImgs);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new ResponseEntity(productId,HttpStatus.OK);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {

    Long productId = productService.deleteProduct(id);

    return new ResponseEntity(productId,HttpStatus.OK);

  }

}
