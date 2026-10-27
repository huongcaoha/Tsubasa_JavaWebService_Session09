package org.example.tsuba260428_session09.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.tsuba260428_session09.model.entity.Doctor;
import org.example.tsuba260428_session09.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandleCheckDoctorCodeExisted implements ConstraintValidator<CheckDoctorCodeExisted,String> {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public boolean isValid(String doctorCode, ConstraintValidatorContext context) {
        Doctor doctor = doctorRepository.findDoctorByDoctorCode(doctorCode);
        return doctor == null;
    }
}
