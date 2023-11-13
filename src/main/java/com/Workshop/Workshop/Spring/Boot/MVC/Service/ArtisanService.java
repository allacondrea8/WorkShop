package com.Workshop.Workshop.Spring.Boot.MVC.Service;

import com.Workshop.Workshop.Spring.Boot.MVC.Models.Artisan;
import java.util.List;
import java.util.Optional;

public interface ArtisanService {
    Artisan saveArtisan(Artisan artisan);
    Optional<Artisan> getArtisanById(Long id);
    List<Artisan> getAllArtisans();
    Artisan updateArtisan(Artisan artisan);
    void deleteArtisan(Long id);
    // Other business logic methods can be defined here
}