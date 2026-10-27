package org.example.tsuba260428_session09.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HandleCheckFileImage implements ConstraintValidator<CheckFileImage, MultipartFile> {
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return false;
        }

        List<String> extensions = Arrays.asList("jpg", "jpeg", "png", "webp");
        String fileName = file.getOriginalFilename();
        String contentType = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf(".") +1).toLowerCase();
        if (!extensions.contains(contentType)){
            return false;
        }
        // giới hạn kích thước file tải lên là 5MB
        long maxSize = 1024 * 1024 * 5 ;

        return file.getSize() <= maxSize;

    }
}
