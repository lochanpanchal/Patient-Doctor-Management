package com.example.hospitalmanagementsystem.Controller;

import com.example.hospitalmanagementsystem.Model.Doctor;
import com.example.hospitalmanagementsystem.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
@Validated
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/hello")
    public String hello(){
        return "hello lochan";
    }

    @PostMapping("/doctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
}
