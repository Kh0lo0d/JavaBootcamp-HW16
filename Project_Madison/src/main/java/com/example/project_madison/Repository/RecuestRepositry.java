package com.example.project_madison.Repository;

import com.example.project_madison.Model.Patient;
import com.example.project_madison.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecuestRepositry extends JpaRepository<Request,Integer> {


    Request findRequestById(Integer id);
    Request findRequestByEmergencyLevel(String emergencyLevel);

    Request findRequestByStatus(String status);

}
