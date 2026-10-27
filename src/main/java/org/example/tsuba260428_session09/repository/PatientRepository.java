package org.example.tsuba260428_session09.repository;

import org.example.tsuba260428_session09.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
