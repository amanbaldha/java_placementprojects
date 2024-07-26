package com.example.PlacementManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PlacementManagement.entities.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
