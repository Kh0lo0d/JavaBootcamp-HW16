package com.example.project_madison.Service;

import com.example.project_madison.Exception.ApiException;
import com.example.project_madison.Model.Insurance;
import com.example.project_madison.Repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    public final InsuranceRepository insuranceRepository;


    public List<Insurance> getInsuranceCompany()

    {
        return insuranceRepository.findAll();

    }

    public void  addInsuranceCompany( Insurance insurance)

    {
        insuranceRepository.save(insurance);
    }

    public void  updateInsuranceCompany( Insurance insurance, Integer id)

    {

        Insurance old = insuranceRepository.findByInsuranceId(id);
        if (old==null)
        {         throw new ApiException(" Insurance Company  not found");
        }

        old.setName(insurance.getName());
        old.setPatientId(insurance.getPatientId());
        insuranceRepository.save(old);
    }

    public void  deleteInsuranceCompany( Integer id)

    {

        Insurance old = insuranceRepository.findByInsuranceId(id);
        if (old !=null)
        {

            insuranceRepository.deleteById(id);
        }

        throw new ApiException(" Insurance Company not found");



    }




}
