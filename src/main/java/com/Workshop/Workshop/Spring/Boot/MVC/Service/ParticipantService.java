package com.Workshop.Workshop.Spring.Boot.MVC.Service;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Participant;
import com.Workshop.Workshop.Spring.Boot.MVC.Repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
}
