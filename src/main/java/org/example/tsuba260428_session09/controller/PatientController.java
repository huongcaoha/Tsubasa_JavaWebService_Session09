package org.example.tsuba260428_session09.controller;

import jakarta.validation.Valid;
import org.example.tsuba260428_session09.model.dto.request.PatientCreateDTO;
import org.example.tsuba260428_session09.model.dto.response.ApiResponse;
import org.example.tsuba260428_session09.model.entity.Patient;
import org.example.tsuba260428_session09.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping
    public ApiResponse<Patient> addPatient(@Valid @ModelAttribute PatientCreateDTO patientCreateDTO){
        return ApiResponse
                .<Patient>builder()
                .status(201)
                .message("Thêm mới bệnh nhân thành công")
                .data(patientService.addPatient(patientCreateDTO))
                .build();
    }
}
