package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    String upload(MultipartFile multipartFile) throws ImageUploadException;
}
