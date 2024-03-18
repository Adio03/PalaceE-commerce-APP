package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CloudinaryTest {
    @Autowired
    private CloudinaryService cloudinaryService;
    public static String IMAGE_LOCATION = "C:\\Users\\mr Adio\\IdeaProjects\\PalaceE-commerce-App\\src\\main\\resources\\assets\\Garri.jpeg";


    @Test
    public void uploadImageTest() throws ImageUploadException {
        String response = cloudinaryService.upload(getFileTest(IMAGE_LOCATION));
        assertNotNull(response);


    }
    public static MultipartFile getFileTest(String fileLocation){
        Path path = Paths.get(fileLocation);
        try(var inputStream = Files.newInputStream(path)){
            MultipartFile file =new MockMultipartFile(path.getFileName().toString(),inputStream);
            return file;
        }catch (IOException exception){
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
        }
    }

