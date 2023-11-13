package com.Workshop.Workshop.Spring.Boot.MVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Workshop.Workshop.Spring.Boot.MVC.Repository.AtelierRepository;
import com.Workshop.Workshop.Spring.Boot.MVC.Models.Atelier;

@Service
public class AtelierService {

    private final AtelierRepository atelierRepository;

    @Autowired
    public AtelierService(AtelierRepository atelierRepository) {
        this.atelierRepository = atelierRepository;
    }

    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }
    //  methods for creating, updating and deleting ateliers
    public Atelier saveAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    public Optional<Atelier> getAtelierById(Long id) {
        return atelierRepository.findById(id);
    }

    public void deleteAtelier(Long id) {
        atelierRepository.deleteById(id);
    }

    public List<Atelier> findAll() {
        // Assuming you have an AtelierRepository that extends JpaRepository or similar
        return atelierRepository.findAll();
    }


    public Atelier findById(Long id) {
        // This uses Java 8's Optional, change if using a different version
        Optional<Atelier> atelier = atelierRepository.findById(id);
        return atelier.orElse(null); // Return the atelier if found, or null if not found
    }



}

