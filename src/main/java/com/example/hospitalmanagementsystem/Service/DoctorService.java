package com.example.hospitalmanagementsystem.Service;

import com.example.hospitalmanagementsystem.Model.Doctor;
import com.example.hospitalmanagementsystem.Repositrory.DoctorRepository;
import org.apache.tomcat.Jar;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Locale;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public ResponseEntity<String> addDoctor(Doctor doctor){
        if(valid(doctor).isEmpty()){
            doctorRepository.save(doctor);
            return new ResponseEntity<>("Doctor profile created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(valid(doctor).toString(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> deleteDoctor(int doctorId){
        if(!doctorRepository.findById(doctorId).isPresent()){
            return new ResponseEntity<>("Doctor with given id is not present",HttpStatus.NOT_FOUND);
        }
        else{
            doctorRepository.deleteById(doctorId);
            return new ResponseEntity<>("Doctor deleted successfully",HttpStatus.OK);
        }
    }


    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }


    private JSONObject valid(Doctor doctor){

        JSONObject errors = new JSONObject();

        String city = doctor.getDoctorCity().toLowerCase();
        if(!(city.equals("noida") || city.equals("faridabad") || city.equals("delhi"))){
            errors.put(city,"Doctor's location should be in NCR");
        }

        String speciality = doctor.getDoctorSpecialization().toLowerCase();
        if(!(speciality.equals("orthopedic") || speciality.equals("gynecology")
        || speciality.equals("dermatology")|| speciality.equals("ent"))){
            errors.put(speciality,"Doctor's speciality should be in " + "Orthopedic, Gynecology, Dermatology, ENT");
        }

        return errors;
    }
}
