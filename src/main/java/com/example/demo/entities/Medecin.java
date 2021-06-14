package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medecin extends User{

    @Column(length = 25)
    @NotEmpty
    @Size(min=5, max=12)
    private String name;
    private String specialite;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> listRendezVous;
}
