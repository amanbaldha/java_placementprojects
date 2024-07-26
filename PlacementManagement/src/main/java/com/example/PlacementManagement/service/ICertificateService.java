package com.example.PlacementManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacementManagement.entities.Certificate;
import com.example.PlacementManagement.repository.ICertificateRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ICertificateService {
	@Autowired
    private ICertificateRepository repo;

    public List<Certificate> listAll() {
        return repo.findAll();
    }

    public void save(Certificate certificate) {
        repo.save(certificate);
    }

    public Certificate get(int id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
