package com.example.project_madison.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Madison {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
 @NotEmpty(message="Name should be not empty")
 @Column(columnDefinition = "varchar(10) unique not null ")
 private String name;
 @NotNull(message="price should be not empty")
 @Positive(message="price must be Integer and grater than 0")
 private double price;
 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
 private Date expire;
 @NotNull(message="quantity should be not empty")
 @PositiveOrZero(message="quantity must be Integer")
 private Integer quantity;
 private Integer patientId;
 private Integer request_id;


}
