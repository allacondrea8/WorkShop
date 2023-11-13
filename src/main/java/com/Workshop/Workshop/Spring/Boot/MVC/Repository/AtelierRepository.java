package com.Workshop.Workshop.Spring.Boot.MVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Atelier;

public interface AtelierRepository extends JpaRepository<Atelier, Long> {
    // Custom query methods if needed
}

