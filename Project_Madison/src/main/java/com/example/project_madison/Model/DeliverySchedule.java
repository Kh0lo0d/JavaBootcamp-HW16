package com.example.project_madison.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class DeliverySchedule{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    private Integer patientid;

    @Column(columnDefinition = "int not null")
    private Integer requestId;

    @Column(columnDefinition = "varchar(50) not null")
    private String Day;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy hh:mm")
    @Column(columnDefinition = "DATETIME not null")
    private Date date_delivery;


}
