package com.automationfraternity;

import com.automationfraternity.model.AppointmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<AppointmentEntity,Long> {

//    @Query("SELECT c from AppointmentEntity c where c.doctorEmail = ?1 AND c.appointmentDate = ?2 AND (c.appointmentTimeFrom >= ?3 OR c.appointmentTimeTill <= ?4)")
//    public List<AppointmentEntity> findAllDoctorAppointmentWithConditions(String doctorEmail, Date appointmentDate, Timestamp APPOINTMENT_TIME_FROM, Timestamp APPOINTMENT_TIME_TILL);

}
