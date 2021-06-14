package com.example.demo.service;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;
import com.example.demo.repositories.ConsultationRepository;
import com.example.demo.repositories.MedecinRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class MedicalDbInitServiceImpl implements ImedicalDbInitService{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public void initPatient() {
        Stream.of("AHMED", "John", "Malika", "luna").forEach((patientName)->{
            Patient p = new Patient();
            p.setName(patientName);
            patientRepository.save(p);
        });
    }

    @Override
    public void initMedecin() {
        Stream.of("Pr ZAKI", "Chopper san", "Pr Maqhoul").forEach((medecinName)->{
            Medecin m = new Medecin();
            m.setName(medecinName);
            medecinRepository.save(m);
        });
    }

    @Override
    public void initRendezVous() {
        List<Patient> patientList = patientRepository.findAll();
        List<Medecin> medecinList = medecinRepository.findAll();
        Stream.of(true, false, false, true, true, true).forEach((maintenue)->{
            RendezVous rendezVous = new RendezVous();
            rendezVous.setMaintenue(maintenue);
            rendezVous.setPatient(patientList.get(new Random().nextInt(patientList.size())));
            rendezVous.setMedecin(medecinList.get(new Random().nextInt(medecinList.size())));
            rendezVousRepository.save(rendezVous);
        });
    }

    @Override
    public void initConsultation() {
        String descriptions[]={"description 1","description 2", "description 3", "description 4"};
        String traitements[]={"traitement 1","traitement 2", "traitement 3", "traitement 4"};
        String types[] = {"presentielle","distancielle","distancielle","presentielle","distancielle","presentielle"};
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();

        for (int i = 0;i< types.length; i++) {
            Consultation consultation = new Consultation();
            consultation.setDescription(descriptions[new Random().nextInt(descriptions.length)]);
            consultation.setTraitement(traitements[new Random().nextInt(traitements.length)]);
            consultation.setDescription(descriptions[new Random().nextInt(descriptions.length)]);
            consultation.setType(types[i]);
            consultation.setRendezVous(rendezVousList.get(i));
            consultationRepository.save(consultation);
        }

    }



}
