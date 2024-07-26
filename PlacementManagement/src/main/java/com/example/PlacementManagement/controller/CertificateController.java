package com.example.PlacementManagement.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.PlacementManagement.entities.*;
import com.example.PlacementManagement.service.ICertificateService;

@RestController
@RequestMapping("/certificatelist")
public class CertificateController {


    @Autowired
    private ICertificateService certificateService;

    // Retrieve all certificates
    @GetMapping
    public List<Certificate> list() {
        return certificateService.listAll();
    }

    // Retrieve a specific certificate by ID
    @GetMapping("/certificatelist/{id}")
    public ResponseEntity<Certificate> get(@PathVariable int id) {
        try {
            Certificate certificate = certificateService.get(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new certificate
    @PostMapping
    public void add(@RequestBody Certificate certificate) {
        certificateService.save(certificate);
    }

    // Update an existing certificate
    @PutMapping("/certificatelist/{id}")
    public ResponseEntity<?> update(@RequestBody Certificate certificate, @PathVariable int id) {
        try {
            Certificate existCertificate = certificateService.get(id);
            if (existCertificate != null) {
                certificate.setId(id);
                certificateService.save(certificate);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a certificate
    @DeleteMapping("/certificatelist/{id}")
    public void delete(@PathVariable Long id) {
        certificateService.delete(id);
    }
}
