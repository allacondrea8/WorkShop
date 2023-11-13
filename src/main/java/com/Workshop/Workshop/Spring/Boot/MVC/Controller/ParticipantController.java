package com.Workshop.Workshop.Spring.Boot.MVC.Controller;


import com.Workshop.Workshop.Spring.Boot.MVC.Models.Participant;
import com.Workshop.Workshop.Spring.Boot.MVC.Service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    // Display the form to create a new participant
    @GetMapping("/new")
    public String showParticipantForm(Participant participant) {
        return "participants/new"; // Path to the Thymeleaf template for creating a new participant
    }

    // Process the form submission
    @PostMapping("/save")
    public String saveParticipant(@Validated Participant participant, 
                                  BindingResult bindingResult, 
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "participants/new";
        }
        participant = participantService.saveParticipant(participant);
        redirectAttributes.addFlashAttribute("participant", participant);
        return "redirect:/participants/confirmation"; // Redirect to a confirmation page or another appropriate URL
    }

    // Confirmation page after a successful save
    @GetMapping("/confirmation")
    public String showConfirmation() {
        return "participants/confirmation"; // Path to the Thymeleaf template for the confirmation page
    }
}
