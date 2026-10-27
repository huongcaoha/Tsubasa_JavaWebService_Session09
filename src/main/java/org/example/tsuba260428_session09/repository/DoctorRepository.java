package org.example.tsuba260428_session09.repository;

import org.example.tsuba260428_session09.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Doctor findDoctorByDoctorCode(String doctorCode);
}
