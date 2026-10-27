package org.example.tsuba260428_session09.service;

import org.example.tsuba260428_session09.model.dto.request.PatientCreateDTO;
import org.example.tsuba260428_session09.model.entity.Patient;
import org.example.tsuba260428_session09.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UploadService uploadService ;

    public Patient addPatient(PatientCreateDTO patientCreateDTO) {
        Patient patient = new Patient();
        patient.setPatientName(patientCreateDTO.getPatientName());
        patient.setPhoneNumber(patientCreateDTO.getPhoneNumber());
//        String newUrlImage = UploadService.uploadFile(patientCreateDTO.getAvatarFile()); // upload lên thư mục của dự án
        String newUrlImage = uploadService.uploadCloudinary(patientCreateDTO.getAvatarFile()); // upload lên cloudinary
        patient.setAvatarUrl(newUrlImage);
        return patientRepository.save(patient);
    }
}
