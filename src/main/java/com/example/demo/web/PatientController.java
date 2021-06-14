package com.example.demo.web;

import javax.validation.Valid;

import com.example.demo.entities.Medecin;
import com.example.demo.entities.RendezVous;
import com.example.demo.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

import java.util.List;

@Controller()
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private MedecinRepository medecinRepository;

	@GetMapping(path = "/")
	public String welcomePage() {
		return "layout";
	}
	@GetMapping(path = "/index")
	public String listPatient(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {

		Page<Patient> list = patientRepository.findByNameContains(keyword, PageRequest.of(page, size));
		model.addAttribute("list", list.getContent());
		model.addAttribute("pages", new int[list.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", keyword);
		model.addAttribute("size", size);
		return "patientView";
	}

	@GetMapping(path = "/deletePatient")
	public String delete(Long id, String keyword, int page, int size) { // @requestparam not necessary because name of
																		// param is same with name of variable
		patientRepository.deleteById(id);
		return "redirect:/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
	}

	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {

		model.addAttribute("patient", new Patient());
		model.addAttribute("mode", "new");
		return "formPatient";
	}

	@PostMapping(path = "/savePatient")
	public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formPatient";
		patientRepository.save(patient);
		return "redirect:/index";
	}

	@GetMapping(path = "/priseRdv")
	public String priseRDV(Model model, Long id) { // @requestparam not necessary because name of
		// param is same with name of variable
		Patient p = patientRepository.findById(id).get();
		List<Medecin> medecinList = medecinRepository.findAll();
		model.addAttribute("rdv", new RendezVous());
		model.addAttribute("patient", p);
		model.addAttribute("listMedecin", medecinList);
		return "formRDV";
	}
	@GetMapping(path = "/editPatient")
	public String editPatient(Model model, Long id) {
		Patient p = patientRepository.findById(id).get();
		model.addAttribute("patient", p);
		model.addAttribute("mode", "edit");
		return "formPatient";
	}
	@GetMapping(path = "/medecins")
	public String listMedecin(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
							  @RequestParam(name = "size", defaultValue = "3") int size,
							  @RequestParam(name = "keyword", defaultValue = "") String keyword) {

		Page<Medecin> list = medecinRepository.findByNameContains(keyword, PageRequest.of(page, size));
		model.addAttribute("list", list.getContent());
		model.addAttribute("pages", new int[list.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", keyword);
		model.addAttribute("size", size);
		return "medecinView";
	}
}
