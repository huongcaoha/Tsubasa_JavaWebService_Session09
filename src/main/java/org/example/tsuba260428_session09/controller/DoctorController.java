package org.example.tsuba260428_session09.controller;

import jakarta.validation.Valid;
import org.example.tsuba260428_session09.model.dto.request.DoctorCreateDTO;
import org.example.tsuba260428_session09.model.dto.request.DoctorUpdateDTO;
import org.example.tsuba260428_session09.model.dto.response.ApiResponse;
import org.example.tsuba260428_session09.model.entity.Doctor;
import org.example.tsuba260428_session09.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ApiResponse<List<Doctor>> findAll(){
        return ApiResponse
                .<List<Doctor>>builder()
                .status(200)
                .message("Lấy danh sách bác sĩ thành công")
                .data(doctorService.findAll())
                .build();
    }
    @PostMapping
    public ResponseEntity<Doctor> addDoctor (@Valid @RequestBody DoctorCreateDTO doctorCreateDTO){
        return new ResponseEntity<>(doctorService.addDoctor(doctorCreateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id){
        return new ResponseEntity<>(doctorService.deleteDoctor(id),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable long id , @RequestBody DoctorUpdateDTO doctorUpdateDTO){
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorUpdateDTO), HttpStatus.OK);
    }

}
