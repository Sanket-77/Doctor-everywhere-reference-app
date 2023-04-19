package com.automationfraternity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface IDoctorRepository extends MongoRepository<Doctor, Long> {
//    List<Doctor> findByName(String name);
    List<Doctor> findByEmailID(String emailID);
    Optional<Doctor> findByRegistrationID(String registrationID);
    void deleteByRegistrationID(String registrationID);

}
