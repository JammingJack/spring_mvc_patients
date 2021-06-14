package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="RENDEZVOUS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean maintenue;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;
    @OneToOne
    private Consultation consultation;
}
