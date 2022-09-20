package com.project.catcher.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Slf4j
@Service
public class S3UploadService {

  @Value("${cloud.aws.s3.bucket}")
  private String bucket;

  private final AmazonS3 amazonS3;

  public String upload(MultipartFile multipartFile, String dirName) throws IOException {

    String fileName = dirName + "/" + UUID.randomUUID();
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
    metadata.setContentLength(multipartFile.getSize());

    amazonS3.putObject(new PutObjectRequest(bucket,fileName,multipartFile.getInputStream()
    ,metadata).withCannedAcl(CannedAccessControlList.PublicRead));

    return  amazonS3.getUrl(bucket,fileName).toString();

  }
}