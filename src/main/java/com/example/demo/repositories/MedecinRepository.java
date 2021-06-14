package com.example.demo.repositories;

import com.example.demo.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    public Page<Medecin> findByNameContains(String name, Pageable pageable);
}