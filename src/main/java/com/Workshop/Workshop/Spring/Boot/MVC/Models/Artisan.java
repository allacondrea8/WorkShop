package com.Workshop.Workshop.Spring.Boot.MVC.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artisans")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String spécialité;

    @OneToMany(mappedBy = "artisan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Atelier> ateliers = new HashSet<>();

	public Artisan(Long id, String nom, String email, String spécialité, Set<Atelier> ateliers) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.spécialité = spécialité;
		this.ateliers = ateliers;
	}
	public Artisan() {
	    // Constructeur par défaut vide
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

	public String getSpécialité() {
		return spécialité;
	}

	public void setSpécialité(String spécialité) {
		this.spécialité = spécialité;
	}

	public Set<Atelier> getAteliers() {
		return ateliers;
	}

	public void setAteliers(Set<Atelier> ateliers) {
		this.ateliers = ateliers;
	}

    // Standard constructors, getters, setters, equals, and hashCode methods
    
    
    
}
