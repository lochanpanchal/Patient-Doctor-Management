package com.example.hospitalmanagementsystem.Repositrory;

import com.example.hospitalmanagementsystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
