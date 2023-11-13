package com.Workshop.Workshop.Spring.Boot.MVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Vous pouvez définir des requêtes personnalisées ici si nécessaire, par exemple:
    // List<Reservation> findAllByParticipantId(Long participantId);
}
