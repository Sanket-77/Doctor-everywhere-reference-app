package com.automationfraternity.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@ToString
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor

public class DoctorEntity {
    @Id
    String id;
    String name;
    String registrationID;
    String qualifications;
    String specialization;
    Integer experienceInYears;
    String emailID;
    String clinicNameAndAddress;
    Boolean canDoHomeVisit;
    Boolean isDoctorAvailable;

}


