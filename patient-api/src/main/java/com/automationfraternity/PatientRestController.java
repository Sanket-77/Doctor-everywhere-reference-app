package com.automationfraternity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
@CrossOrigin //All origins are allowed. Not a secure way though

public class PatientRestController {

    PatientService patientService;
    @Autowired
    public PatientRestController(PatientService patientService){
        this.patientService = patientService;
//        initDB();
    }

    @PostMapping("/patient")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient){
        patient.setId(generateUUID());
        return patientService.createNewPatient(patient);
    }

    @GetMapping("/patient")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Patient> getPatient(){
        return patientService.getPatient();
    }

    @GetMapping("/patient/searchByEmail")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Patient> getPatientByEmail(@RequestParam String email){
        return patientService.getPatient(email);
    }

    @PutMapping("/patient")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Patient updatePatient(@RequestBody Patient patient) throws Exception {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/patient")
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public void deletePatient(@RequestParam String email){
        patientService.deletePatient(email);
    }

    @PostMapping("/init_db")
    @ResponseStatus(code = HttpStatus.OK)
    public void initDB(){
        Patient patient = Patient.builder().withName("sanket").withAge("25").withEmail("sanket@sanket.com").withPhone("9637967737").withMedicalConditions("any").build();
        Patient patient1 = Patient.builder().withName("prashant").withAge("27").withEmail("prashant@prashant.com").withPhone("7972181924").withMedicalConditions("any").build();
        Patient patient2 = Patient.builder().withName("shubham").withAge("26").withEmail("shubham@shubham.com").withPhone("6576654788").withMedicalConditions("any").build();
        createPatient(patient);
        createPatient(patient1);
        createPatient(patient2);
    }

    public String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
