package com.Workshop.Workshop.Spring.Boot.MVC.Models;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

	
	  public Reservation() {
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}
	public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
	public LocalDateTime getDateTime() {
		return dateTime;
	}


	public StatutReservation getStatut() {
		return statut;
	}

	public void setStatut(StatutReservation statut) {
		this.statut = statut;
	}

	public Reservation(Long id, Participant participant, Atelier atelier, LocalDateTime dateHeure,
			StatutReservation statut, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.participant = participant;
		this.atelier = atelier;
		this.dateTime = dateTime;
		this.statut = statut;
	}


	


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    @Nonnull
    private Participant participant;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "atelier_id")
    private Atelier atelier;

    
    @Column(name = "dateHeure", nullable = false) 
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutReservation statut;

    public enum StatutReservation {
        CONFIRMÉE,
        ANNULÉE
    }



   


    // Standard constructors, getters, setters, equals, and hashCode methods
}
