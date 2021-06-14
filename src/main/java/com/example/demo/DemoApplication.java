package com.example.demo;

import java.util.Date;

import com.example.demo.service.ImedicalDbInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    private ImedicalDbInitService imedicalDbInitService;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        imedicalDbInitService.initPatient();
        imedicalDbInitService.initMedecin();
        imedicalDbInitService.initRendezVous();
        imedicalDbInitService.initConsultation();

    }
}
