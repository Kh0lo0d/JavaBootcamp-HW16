package com.example.project_madison.Service;

import com.example.project_madison.Exception.ApiException;
import com.example.project_madison.Model.Patient;
import com.example.project_madison.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    public final PatientRepository patientRepository;


    public List<Patient> getPatients()
    {

        return patientRepository.findAll();
    }

    public void addPatient( Patient patient)
    {

        patientRepository.save(patient);
    }


    public void updatePatient( Patient patient, Integer id) {
        Patient old = patientRepository.findPatientByPatientId(id);

        if (old == null)
        {
            throw new ApiException(" Patient  not found");
        }


        old.setInsuranceId(patient.getInsuranceId());
        old.setHospitalId(patient.getHospitalId());

        old.setName(patient.getName());
        old.setAge(patient.getAge());
        old.setCity(patient.getCity());
        old.setNationalAddress(patient.getNationalAddress());
        old.setEmail(patient.getEmail());
        old.setBalance(patient.getBalance());
        old.setStartDate(patient.getStartDate());
        old.setLastDate(patient.getLastDate());


        patientRepository.save(old);

    }

    public void deletePatient( Integer id)

    {

        Patient old = patientRepository.findPatientByPatientId(id);
        if(old!=null)
        {
            patientRepository.deleteById(id);
        }
        else throw new ApiException(" Patient  not found");



    }

}
