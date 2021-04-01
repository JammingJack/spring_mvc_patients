package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
    	/*
        patientRepository.save(new Patient(null,"Halima",new Date(),44,false));
        patientRepository.save(new Patient(null,"Ahmed",new Date(),443,true));
        patientRepository.save(new Patient(null,"Joe",new Date(),34,false));
        patientRepository.save(new Patient(null,"Lina",new Date(),222,true));
        patientRepository.save(new Patient(null,"Damas",new Date(),887,false));
        patientRepository.save(new Patient(null,"Karren",new Date(),44,false));
        patientRepository.save(new Patient(null,"Montana",new Date(),44,true));
        patientRepository.save(new Patient(null,"Dave",new Date(),44,false));
        patientRepository.findAll().forEach(p->{
            System.out.println(p);
        });
        System.out.println("***************************");

        System.out.println(patientRepository.findById(3L).get());
        System.out.println("***************************");

        patientRepository.findAll().forEach(p->{
            System.out.println(p);
        });
        */
    }
}
