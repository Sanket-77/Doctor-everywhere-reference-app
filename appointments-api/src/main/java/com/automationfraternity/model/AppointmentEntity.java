package com.automationfraternity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Document("appointments")

public class AppointmentEntity {

    @Id
    String id;
    String date;
    String startTime;
    String endTime;
    String patientEmail;
    String doctorEmail;
    String clinicName;

}

