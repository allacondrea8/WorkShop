package com.Workshop.Workshop.Spring.Boot.MVC.Repository;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Participant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByEmail(String email);
}

