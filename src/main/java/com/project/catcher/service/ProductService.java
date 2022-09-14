package com.project.catcher.service;

import com.project.catcher.dto.ProductRequest;
import com.project.catcher.dto.ProductRequest.ProductCreateDto;
import com.project.catcher.dto.ProductRequest.ProductUpdateDto;
import com.project.catcher.dto.ProductResponse.ProductGetDto;
import com.project.catcher.entity.Brand;
import com.project.catcher.entity.Member;
import com.project.catcher.entity.Product;
import com.project.catcher.entity.ProductCategory;
import com.project.catcher.entity.ProductImg;
import com.project.catcher.repository.MemberRepository;
import com.project.catcher.repository.ProductCategoryRepository;
import com.project.catcher.repository.ProductImgRepository;
import com.project.catcher.repository.ProductRepository;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductImgRepository productImgRepository;
  private final MemberRepository memberRepository;
//  private final BrandRepository brandRepository;

  public ProductGetDto getProduct(Long id) {

    Optional<Product> productOp = productRepository.findById(id);

    Product product = productOp.get();

    return createGetDto(product);
  }

  @Transactional
  public Long createProduct(ProductCreateDto dto,List<MultipartFile> productImgs) {

    // 향후 member util로 변경
    Long memberId = dto.getMemberId();
    Optional<Member> memberOp = memberRepository.findById(memberId);
    Member member = memberOp.get();

    Long categoryId = dto.getCategoryId();
    Long brandId = dto.getBrandId();

    Optional<ProductCategory> productCategoryOp = productCategoryRepository.findById(categoryId);
    ProductCategory productCategory = productCategoryOp.get();

    //brandRepsitory 만들어지면 수정
    Brand brand = new Brand();

    Product product = dto.toProduct(brand, productCategory);
    List<String> productUrls = createProductImg(member.getNickname(), productImgs);

    productRepository.save(product);

    for(String url : productUrls) {
      ProductImg productImg = ProductImg.builder().productId(product).imgUrl(url).build();
      productImgRepository.save(productImg);
    }

    return product.getId();
  }

  @Transactional
  public List<String> createProductImg(String nickname, List<MultipartFile> productImgs) {

    StringBuilder sb = new StringBuilder();
    sb.append(nickname);

    List<String> productImgUrls = new ArrayList<>();

    if (!productImgs.isEmpty()) {
      for (MultipartFile imageName : productImgs) {
        sb.append(imageName.getOriginalFilename());
        String fileName = "/home/ec2-user/images/product/" + sb;

        File dest = new File(fileName);
        try {
          imageName.transferTo(dest);
          productImgUrls.add(fileName);
        } catch (IllegalStateException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return productImgUrls;
  }

  public List<ProductGetDto> getProductList() {

    List<Product> productList = productRepository.findAll();
    List<ProductGetDto> productGetDtoList = new ArrayList<>();

    for(Product product : productList) {
      ProductGetDto productGetDto = createGetDto(product);
      productGetDtoList.add(productGetDto);
    }

    return productGetDtoList;
  }

  public ProductGetDto createGetDto(Product product) {

    List<ProductImg> productImgs = productImgRepository.findAllByProductId(product);

    Long productId = product.getId();
    String productName = product.getName();
    String description = product.getDescription();
    Integer price = product.getPrice();
    Long hits = product.getHits();
    LocalDateTime createdAt = product.getCreatedAt();
    LocalDateTime updatedAt = product.getUpdatedAt();

    ProductCategory productCategory = product.getProductCategoryId();
    String categoryName = productCategory.getName();

    Brand brand = product.getBrandId();
    String brandName = brand.getName();

    List<String> productImgUrls = productImgs.stream().map(productImg -> productImg.getImgUrl())
        .collect(Collectors.toList());

    // member uitl 수정
    Long createdBy = product.getCreatedBy();
    Optional<Member> memberOp = memberRepository.findById(createdBy);
    Member member = memberOp.get();
    String nickname = member.getNickname();
    String imgUrl = member.getImgUrl();

    return ProductGetDto.builder().id(productId).name(productName).description(description).price(price).hits(hits)
        .createAt(createdAt).updateAt(updatedAt).category(categoryName).productImgs(productImgUrls).brand(brandName).nickname(nickname).profileImg(imgUrl)
        .build();
  }

  @Transactional
  public Long deleteProduct(Long id) {

    Optional<Product> productOp = productRepository.findById(id);
    Product product = productOp.get();

    product.delete();

    return product.getId();
  }

  @Transactional
  public Long updateProduct(Long id, ProductUpdateDto dto, List<MultipartFile> productImgs) {

    // 향후 member util로 변경
    Long memberId = dto.getMemberId();
    Optional<Member> memberOp = memberRepository.findById(memberId);
    Member member = memberOp.get();

    Optional<Product> productOp = productRepository.findById(id);
    Product product = productOp.get();

    String productName = dto.getName();
    String description = dto.getDescription();
    Integer price = dto.getPrice();

    //
    Long categoryId = dto.getCategoryId();
    Long brandId = dto.getBrandId();

    Optional<ProductCategory> productCategoryOp = productCategoryRepository.findById(categoryId);
    ProductCategory productCategory = productCategoryOp.get();

    //brandRepsitory 만들어지면 수정
    Brand brand = new Brand();

    product.update(productName,description,price,productCategory,brand);

    deleteProductImgs(product);

    List<String> productUrls = createProductImg(member.getNickname(), productImgs);

    for(String url : productUrls) {
      ProductImg.builder().productId(product).imgUrl(url).build();
    }

    return product.getId();
  }
  @Transactional
  public void deleteProductImgs(Product product) {

    List<ProductImg> productImgs = productImgRepository.findAllByProductId(product);
    for(ProductImg imgs : productImgs) {
      imgs.delete();
    }

  }
}
