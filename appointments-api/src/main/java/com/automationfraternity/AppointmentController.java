package com.automationfraternity;

import com.automationfraternity.exceptions.DoctorNotFoundException;
import com.automationfraternity.exceptions.PatientNotFoundException;
import com.automationfraternity.model.AppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class AppointmentController {

    AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    @PostMapping("/appointment")
    public AppointmentEntity createAppointment(@RequestBody AppointmentEntity entity)throws PatientNotFoundException, DoctorNotFoundException{
        entity.setId(generateUUID());
        return service.createNewAppointment(entity);
    }

    @GetMapping("/appointment")
    public List<AppointmentEntity> getAppointment(){
        return service.getAllAppointment();
    }

    @PutMapping("/appointment")
    public void editAppointment(){

    }

    @DeleteMapping("/appointment")
    public void deleteAppointment(){

    }
    public void init_db(){
//        AppointmentEntity entity = AppointmentEntity.builder()
//                .withBookingTimeStamp(new Timestamp("2023-03-05T06:28:00.489Z"))
//                .withAppointmentDate()
//                .withAppointmentTimeFrom()
//                .withAppointmentTimeTill()
//                .withPatientEmail()
//                .withDoctorEmail()
//                .withClinicName()
//                .build();
    }

    public String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
