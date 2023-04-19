package com.automationfraternity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("doctors")
@Data
@ToString
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {

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
