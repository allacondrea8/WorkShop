package com.Workshop.Workshop.Spring.Boot.MVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Atelier;
import com.Workshop.Workshop.Spring.Boot.MVC.Models.Participant;
import com.Workshop.Workshop.Spring.Boot.MVC.Models.Reservation;
import com.Workshop.Workshop.Spring.Boot.MVC.Repository.AtelierRepository;
import com.Workshop.Workshop.Spring.Boot.MVC.Repository.ParticipantRepository;
import com.Workshop.Workshop.Spring.Boot.MVC.Repository.ReservationRepository;

import jakarta.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {

	

	  
	    
	   private final ReservationRepository reservationRepository;
	    private final AtelierRepository atelierRepository;
	    private final ParticipantRepository participantRepository;

	    @Autowired
	    public ReservationService(ReservationRepository reservationRepository, 
	                              AtelierRepository atelierRepository, 
	                              ParticipantRepository participantRepository) {
	        this.reservationRepository = reservationRepository;
	        this.atelierRepository = atelierRepository;
	        this.participantRepository = participantRepository;
	    }
	    
    @Transactional
    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found for id " + id));

        // If the atelier ID is provided, fetch and set the associated atelier
        if (reservationDetails.getAtelier() != null && reservationDetails.getAtelier().getId() != null) {
            Atelier atelier = atelierRepository.findById(reservationDetails.getAtelier().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Atelier not found for id " + reservationDetails.getAtelier().getId()));
            existingReservation.setAtelier(atelier);
        }

        // Check if the participant exists or create a new one based on the provided email
        Participant participant = participantRepository.findByEmail(reservationDetails.getParticipant().getEmail())
                .orElseGet(() -> participantRepository.save(reservationDetails.getParticipant()));

        // Update the existing reservation with the new details
        existingReservation.setParticipant(participant);
        existingReservation.setDateTime(reservationDetails.getDateTime());
        existingReservation.setStatut(reservationDetails.getStatut());
        // ... any other fields to update

        return reservationRepository.save(existingReservation); // Save the updated reservation
    }


    public Reservation getReservationById(Long id) {
        // Utilisez la méthode findById du repository.
        // Si la réservation est trouvée, elle est retournée; sinon, vous pouvez lancer une exception ou retourner null.
        return reservationRepository.findById(id).orElse(null);
    }
    public Reservation findReservationById(Long id) {
        // This is where orElseThrow is properly used
        return reservationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No reservation found with ID: " + id));
    }
    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        // Here you can add any business logic before saving
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        // Utilisez la méthode deleteById du repository pour supprimer la réservation.
        // Vous pouvez également gérer le cas où l'entité avec cet id n'existe pas.
        reservationRepository.deleteById(id);
    }

    public List<Reservation> findAllReservations() {
        // Utilisez la méthode findAll du repository pour récupérer toutes les réservations.
        return reservationRepository.findAll();
    }

   

}

    // Add any other business logic or helper methods needed


