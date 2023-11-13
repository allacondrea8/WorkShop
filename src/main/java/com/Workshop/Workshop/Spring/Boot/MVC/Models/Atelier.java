package com.Workshop.Workshop.Spring.Boot.MVC.Models;

import java.util.ArrayList;
import java.util.List;



import com.Workshop.Workshop.Spring.Boot.MVC.Models.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ateliers")
public class Atelier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "atelier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "artisan_id") // This column is the foreign key in the Atelier table.
    private Artisan artisan;
    
	public Atelier(Long id, String nom, String description, List<Reservation> reservations) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.reservations = reservations;
	}
	
	  public Atelier() {
	        
	    }
	public Long getId() {
		return id;
	}
	public Artisan getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisan artisan) {
        this.artisan = artisan;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setRéservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

    
    
    // Standard constructors, getters, setters, equals, and hashCode methods
}

