package com.example.project_madison.Repository;
import com.example.project_madison.Model.Madison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RepositoryMadison extends JpaRepository <Madison,Integer>{
     Madison findMedicineById(Integer id);
     Date findMadisonByExpire(String name);
     String findMadisonByName(Integer id);
}
