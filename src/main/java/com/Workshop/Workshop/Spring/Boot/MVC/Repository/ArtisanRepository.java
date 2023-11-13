package com.Workshop.Workshop.Spring.Boot.MVC.Repository;


import com.Workshop.Workshop.Spring.Boot.MVC.Models.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    // You can define custom query methods here if needed
}
