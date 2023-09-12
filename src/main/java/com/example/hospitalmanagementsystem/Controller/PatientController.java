package com.example.hospitalmanagementsystem.Controller;

import com.example.hospitalmanagementsystem.Model.Patient;
import com.example.hospitalmanagementsystem.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@Validated
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/patient/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId){
        return patientService.deletePatient(patientId);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }
}
