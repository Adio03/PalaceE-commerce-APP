package com.example.palaceecommerceapp.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class PalaceCloudinary implements CloudinaryService{
    private Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile multipartFile) throws ImageUploadException {
        try{
            Map<?,?> uploadResponse = cloudinary.uploader().upload(multipartFile.getBytes(),
                    ObjectUtils.asMap(
                            "resources_type","auto"
                    ));
            String url = (String) uploadResponse.get("secure_url");
            return url;
        }catch (IOException exception){
            throw new ImageUploadException(exception.getMessage());
        }
        }

    }

