package com.automationfraternity.model;

import lombok.*;
import org.springframework.data.annotation.Id;
//@Entity
@Getter
@Builder(setterPrefix = "with",toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PatientEntity {
    @Id
    String id;
    String name;
    String age;
    String email;
    String phone;
    String medicalConditions;
}