package com.example.project_madison.Repository;

import com.example.project_madison.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    Patient findPatientByPatientId(Integer id);

}
