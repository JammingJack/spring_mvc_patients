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

    }
}
