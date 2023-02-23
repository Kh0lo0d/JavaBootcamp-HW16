package com.example.project_madison.Repository;

import com.example.project_madison.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
    Insurance findByInsuranceId(Integer id);


}
