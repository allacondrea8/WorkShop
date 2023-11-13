package com.Workshop.Workshop.Spring.Boot.MVC.Service;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Artisan;
import com.Workshop.Workshop.Spring.Boot.MVC.Repository.ArtisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArtisanServiceImpl implements ArtisanService {

    private final ArtisanRepository artisanRepository;

    @Autowired
    public ArtisanServiceImpl(ArtisanRepository artisanRepository) {
        this.artisanRepository = artisanRepository;
    }

    @Override
    public Artisan saveArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    @Override
    public Optional<Artisan> getArtisanById(Long id) {
        return artisanRepository.findById(id);
    }

    @Override
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    @Override
    public Artisan updateArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    @Override
    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }
    
    // Implement other business logic methods as needed
}