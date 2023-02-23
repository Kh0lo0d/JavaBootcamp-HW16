package com.example.project_madison.Cotroller;

import com.example.project_madison.Model.Insurance;
import com.example.project_madison.Service.InsuranceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/insurance")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @GetMapping("/get")
    public ResponseEntity getInsuranceCompany()
    {
        List<Insurance> insurances= insuranceService.getInsuranceCompany();
        return  ResponseEntity.status(200).body(insurances);

    }

    @PostMapping("/add")
    public ResponseEntity addInsuranceCompany(@Valid @RequestBody Insurance insurance)

    {

        insuranceService.addInsuranceCompany(insurance);
        return ResponseEntity.status(200).body(" Insurance Company Added!");

    }


    @PutMapping("/update/{id}")
    public  ResponseEntity updateInsuranceCompany(@PathVariable Integer id, @Valid@RequestBody  Insurance insurance)

    {

        insuranceService.updateInsuranceCompany(insurance,id);
        return ResponseEntity.status(200).body(" Insurance Company updated!");

    }

    @DeleteMapping ("/delete/{id}")
    public  ResponseEntity deleteInsuranceCompany(@PathVariable Integer id)

    {

        insuranceService.deleteInsuranceCompany(id);
        return ResponseEntity.status(200).body(" Insurance Company deleted!");

    }


}
