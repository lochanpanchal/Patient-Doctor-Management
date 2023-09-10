package com.example.hospitalmanagementsystem.Repositrory;

import com.example.hospitalmanagementsystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
