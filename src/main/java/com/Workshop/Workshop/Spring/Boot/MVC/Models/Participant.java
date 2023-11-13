package com.Workshop.Workshop.Spring.Boot.MVC.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

	public Participant(Long id, String nom, String email, List<Reservation> reservations) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.reservations = reservations;
	}

	  // hashCode and equals implementation
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(nom, that.nom) && 
               Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setRéservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	 public Participant() {
	       
	    }
    // Standard constructors, getters, setters, equals, and hashCode methods
}
