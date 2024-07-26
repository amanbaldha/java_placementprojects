package com.example.PlacementManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PlacementManagement.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

}
