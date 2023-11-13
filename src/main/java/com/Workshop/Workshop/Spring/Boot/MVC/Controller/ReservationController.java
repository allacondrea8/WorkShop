package com.Workshop.Workshop.Spring.Boot.MVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Participant;
import com.Workshop.Workshop.Spring.Boot.MVC.Models.Reservation;
import com.Workshop.Workshop.Spring.Boot.MVC.Service.ReservationService;




@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation_liste")
    public String listReservations(Model model) {
        logger.info("Listing reservations"); 
        List<Reservation> reservations = reservationService.findAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations/reservation_liste";
    }



    @GetMapping("/{id}")
    public String getReservation(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservationById(id));
        return "reservations/reserver";
    }

    @PostMapping("/save")
    public String saveReservation(@Validated @ModelAttribute("reservation") Reservation reservation, 
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "reservations/reserver"; // Make sure this is the correct path to your reservation form
        }

        // Here you would typically extract and save the participant separately
        // Assuming the participant does not exist and needs to be saved with the reservation
        Participant participant = new Participant(null, reservation.getParticipant().getNom(),
                                                  reservation.getParticipant().getEmail(), null);
        reservation.setParticipant(participant);

        // Set the status if it is null
        if (reservation.getStatut() == null) {
            reservation.setStatut(Reservation.StatutReservation.CONFIRMÉE);
        }
        reservation.getAtelier().getNom();
        Reservation savedReservation = reservationService.saveReservation(reservation);
        redirectAttributes.addFlashAttribute("reservation", savedReservation);
        return "redirect:/reservations/confirmation";
    }



    
    @GetMapping("/confirmation")
    public String showConfirmation(@ModelAttribute("reservation") Reservation reservation, Model model) {
        // Make sure to add the reservation object to the model if not already present
        model.addAttribute("reservation", reservation);
        return "reservations/confirmation";
    }

  

    
    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/reservation_liste"; // Adjust the redirect if necessary
    }  
    
    
    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditReservationForm(@PathVariable Long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservation);
        return "reservations/edit"; 
    }
    
    // Process the update
    @PostMapping("/update/{id}")
    public String updateReservation(@PathVariable Long id, @Validated @ModelAttribute("reservation") Reservation reservation, 
                                    BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("reservation", reservation);
            return "reservations/edit"; // Stay on the edit form in case of errors
        }
        reservationService.updateReservation(id, reservation);
        return "redirect:/reservations/reservation_liste"; // Adjust the redirect if necessary
    }

}
    