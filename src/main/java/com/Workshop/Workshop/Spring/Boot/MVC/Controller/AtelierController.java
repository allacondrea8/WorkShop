package com.Workshop.Workshop.Spring.Boot.MVC.Controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Atelier;
import com.Workshop.Workshop.Spring.Boot.MVC.Models.Participant;
import com.Workshop.Workshop.Spring.Boot.MVC.Models.Reservation;
import com.Workshop.Workshop.Spring.Boot.MVC.Service.AtelierService;

@Controller
@RequestMapping("/ateliers")
public class AtelierController {

    private final AtelierService atelierService;

    @Autowired
    public AtelierController(AtelierService atelierService) {
        this.atelierService = atelierService;
    }

    // This method handles displaying the form for making a reservation for an atelier
    @GetMapping("/reserver/{id}")
    public String showReservationForm(@PathVariable("id") Long id, Model model) {
        Optional<Atelier> atelierOptional = atelierService.getAtelierById(id);
        if (!atelierOptional.isPresent()) {
            // Atelier not found, redirect to an error page
            return "redirect:/error";
        }
        
        // Create a new reservation object and initialize it
        Reservation reservation = new Reservation(id, null, null, null, null, null);
        reservation.setAtelier(atelierOptional.get());
        reservation.setParticipant(new Participant()); // Initialize the participant object
        model.addAttribute("reservation", reservation);
        
        // Return the path to the reservation form view
        return "reservations/reservation";
    }

    // List all ateliers
    @GetMapping("/list")
    public String listAteliers(Model model) {
        List<Atelier> allAteliers = atelierService.findAll(); // Make sure this method works correctly
        System.out.println("Ateliers found: " + allAteliers.size()); // Simple log to check the data
        model.addAttribute("ateliers", allAteliers);
        return "ateliers/list";
    }


    // ... other methods ...
}
