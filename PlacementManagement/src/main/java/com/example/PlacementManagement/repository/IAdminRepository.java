package com.example.PlacementManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PlacementManagement.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
