package org.example.tsuba260428_session09.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleCheckFileImage.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckFileImage {
    String message() default "File ảnh không được để trống và dưới 5MB hoặc phải là đuôi jpg ,jpeg ,png ,webp";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
