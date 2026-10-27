package org.example.tsuba260428_session09.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class UploadService {
    @Autowired
    private Cloudinary cloudinary;

    public static String uploadFile(MultipartFile file){
        Path uploadDir = Paths.get("src/main/resources/uploads").toAbsolutePath().normalize();
        if(!Files.exists(uploadDir)){
            try {
                Files.createDirectories(uploadDir);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        String fileName =  file.getOriginalFilename();
        Path newPath = uploadDir.resolve(fileName);
        try {
            file.transferTo(newPath);
            return newPath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String uploadCloudinary(MultipartFile file){
        try {
           Map<String , Object> upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
           return upload.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
