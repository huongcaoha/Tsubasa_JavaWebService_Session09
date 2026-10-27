package org.example.tsuba260428_session09.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.aspectj.bridge.IMessage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleCheckDoctorCodeExisted.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckDoctorCodeExisted {
    String message() default "Mã bác sĩ đã tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
