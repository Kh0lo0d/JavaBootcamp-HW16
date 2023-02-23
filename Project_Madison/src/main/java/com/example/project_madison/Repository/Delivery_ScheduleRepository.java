package com.example.project_madison.Repository;

import com.example.project_madison.Model.DeliverySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Delivery_ScheduleRepository extends JpaRepository <DeliverySchedule,Integer> {

}
