package com.example.demo.repositories;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}