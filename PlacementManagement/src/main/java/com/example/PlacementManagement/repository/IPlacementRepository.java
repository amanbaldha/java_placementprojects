package com.example.PlacementManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PlacementManagement.entities.Placement;

public interface IPlacementRepository extends JpaRepository<Placement, Integer> {

}
