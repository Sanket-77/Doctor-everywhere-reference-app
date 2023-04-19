package com.automationfraternity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder(setterPrefix = "with",toBuilder = true)
@ToString
@Document("patient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
    @Id
    String id;
    String name;
    String age;
    String email;
    String phone;
    String medicalConditions;

}
