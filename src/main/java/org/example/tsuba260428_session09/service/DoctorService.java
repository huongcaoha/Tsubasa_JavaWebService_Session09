package org.example.tsuba260428_session09.service;

import org.example.tsuba260428_session09.model.dto.request.DoctorCreateDTO;
import org.example.tsuba260428_session09.model.dto.request.DoctorUpdateDTO;
import org.example.tsuba260428_session09.model.entity.Doctor;
import org.example.tsuba260428_session09.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(DoctorCreateDTO doctorCreateDTO){
        Doctor newDoctor = Doctor
                .builder()
                .doctorCode(doctorCreateDTO.getDoctorCode())
                .fullName(doctorCreateDTO.getFullName())
                .specialization( doctorCreateDTO.getSpecialization() )
                .experienceYears( doctorCreateDTO.getExperienceYears() )
                .build();
        return doctorRepository.save(newDoctor);
    }
    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public String deleteDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy bác sĩ có id như vậy"));
        doctorRepository.delete(doctor);
        return "Xóa bác sĩ thành công";
    }

    public Doctor updateDoctor(long id , DoctorUpdateDTO doctorUpdateDTO){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy bác sĩ có id như vậy"));
        doctor.setFullName(doctorUpdateDTO.getFullName());
        doctor.setSpecialization(doctorUpdateDTO.getSpecialization());
        doctor.setExperienceYears(doctorUpdateDTO.getExperienceYears());
        return doctorRepository.save(doctor);
    }

}
