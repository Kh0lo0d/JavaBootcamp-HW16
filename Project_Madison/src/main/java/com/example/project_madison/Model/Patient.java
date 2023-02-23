package com.example.project_madison.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;//primary key
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "varchar(20) not null")
    private String age;
    @Column(columnDefinition = "int not null")

    private Integer hospitalId; //foreign key
    @Column(columnDefinition = "varchar(20) not null")
    private  String city;
    @Column(columnDefinition = "varchar(4) not null")

    private  String nationalAddress;// 4 number
    @Column(columnDefinition = "varchar(10) not null")

    private  String phone;
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @Column(columnDefinition = "int not null")
    private Integer insuranceId;//foreign key


    @NotNull(message="price should be not empty")
    @Positive(message="price must be Integer and grater than 0")
    private double balance;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date StartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date lastDate;


}
