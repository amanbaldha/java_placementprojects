package com.example.PlacementManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PlacementManagement.entities.Certificate;

public interface ICertificateRepository extends JpaRepository<Certificate, Integer> {

	Optional<Certificate> findById(Long id);

	void deleteById(Long id);

}
