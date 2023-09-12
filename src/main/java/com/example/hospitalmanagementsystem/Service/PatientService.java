package com.example.hospitalmanagementsystem.Service;


import com.example.hospitalmanagementsystem.Model.Patient;

import com.example.hospitalmanagementsystem.Repositrory.PatientRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public ResponseEntity<String> addPatient(Patient patient){
        if(valid(patient).isEmpty()){
            patientRepository.save(patient);
            return new ResponseEntity<>("patient profile created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(valid(patient).toString(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> deletePatient(int patientId){
        if(!patientRepository.findById(patientId).isPresent()){
            return new ResponseEntity<>("patient with given id is not present",HttpStatus.NOT_FOUND);
        }
        else{
            patientRepository.deleteById(patientId);
            return new ResponseEntity<>("Doctor deleted successfully",HttpStatus.OK);
        }
    }


    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }


    private JSONObject valid(Patient patient){

        JSONObject errors = new JSONObject();

        String city = patient.getPatientCity().toLowerCase();
        if(!(city.equals("noida") || city.equals("faridabad") || city.equals("delhi"))){
            errors.put(city,"We are still waiting to expand to your location");
        }

        String symptoms = patient.getSymptoms().toLowerCase();
        if(symptoms.equals("Arthritis") || symptoms.equals("Back Pain") || symptoms.equals("Dysmenorrhea")
                || symptoms.equals("Skin infection") || symptoms.equals("Ear pain")){
            errors.put(symptoms,"There isn't any doctor present at your location for your symptom");
        }

        return errors;
    }


}
