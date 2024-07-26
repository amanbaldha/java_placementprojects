package com.example.PlacementManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PlacementManagement.entities.College;

public interface ICollegeRepository extends JpaRepository<College, Integer>{
}
