//package com.project.catcher.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.project.catcher.dto.ProductRequestDto.ProductCreateDto;
//import com.project.catcher.dto.ProductRequestDto.ProductUpdateDto;
//import com.project.catcher.dto.ProductResponseDto.ProductGetDto;
//import com.project.catcher.entity.Product;
//import com.project.catcher.repository.ProductRepository;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//@SpringBootTest
////@Transactional
//class ProductServiceTest {
//
//  @Autowired
//  private ProductService productService;
//
//  @Autowired
//  private ProductRepository productRepository;
//
//  @Test
//  void getProduct() {
//
//    // when
//    ProductGetDto product = productService.getProduct(10L);
//
//    //then
//    System.out.println(product);
//
//  }
//
//  @Test
//  void createProduct() throws IOException {
//
//    //given
//    ProductCreateDto productCreateDto = new ProductCreateDto("test4","test4",5000,1L,1L,1L);
//    List<MultipartFile> productImgs = new ArrayList<>();
//
//    MultipartFile multipartFile1 = new MockMultipartFile("3","3.png","image/png",new FileInputStream(
//        "C:\\Users\\Jang\\Downloads\\새 ALZip ZIP File\\3.png"));
//    MultipartFile multipartFile2 = new MockMultipartFile("4","4.png","image/png",new FileInputStream(
//        "C:\\Users\\Jang\\Downloads\\새 ALZip ZIP File\\4.png"));
//
//    productImgs.add(multipartFile1);
//    productImgs.add(multipartFile2);
//
//    //when
//    productService.createProduct(productCreateDto,productImgs);
//
//    //then
////    List<Product> products = productRepository.findAll();
////    assertEquals(3,products.size());
//
//  }
//
//  @Test
//  void getProductList() {
//
//    //when
//    List<ProductGetDto> productList = productService.getProductList();
//
//    //then
//    List<Product> products = productRepository.findAll();
//    assertEquals(productList.size(),products.size());
//  }
//
//  @Test
//  void deleteProduct() {
//
//    // when
//    productService.deleteProduct(8L);
//
//    // then
//    List<ProductGetDto> productList = productService.getProductList();
//    assertEquals(1,productList.size());
//
//    Product product = productRepository.findById(8L).get();
//    assertTrue(product.getIsDelete());
//  }
//
//  @Test
//  void updateProduct() throws IOException {
//
//    // givne
//    ProductUpdateDto productUpdateDto = new ProductUpdateDto("updateTest","UpdateTest",10000,1L,1L,1L);
//
//    List<MultipartFile> productImgs = new ArrayList<>();
//
////    MultipartFile multipartFile1 = new MockMultipartFile("3","3.png","image/png",new FileInputStream(
////        "C:\\Users\\Jang\\Downloads\\새 ALZip ZIP File\\3.png"));
////    MultipartFile multipartFile2 = new MockMultipartFile("4","4.png","image/png",new FileInputStream(
////        "C:\\Users\\Jang\\Downloads\\새 ALZip ZIP File\\4.png"));
////
////    productImgs.add(multipartFile1);
////    productImgs.add(multipartFile2);
//
//
//    // when
//    productService.updateProduct(7L,productUpdateDto,productImgs);
//
//    // then
//    ProductGetDto product = productService.getProduct(7L);
//    String name = product.getName();
//    String description = product.getDescription();
//    Integer price = product.getPrice();
//    LocalDateTime updateAt = product.getUpdateAt();
//    List<String> productImgs1 = product.getProductImgs();
//
//    assertEquals("updateTest",name);
//    assertEquals("UpdateTest",description);
//    assertEquals(10000,price);
//    System.out.println(updateAt);
//    for(String s : productImgs1) {
//      System.out.println(s);
//    }
//
//  }
//
//}