package com.lax.carouts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lax.carouts.dto.PrestationDto;
import com.lax.carouts.model.Prestation;
import com.lax.carouts.service.PrestationService;

@Controller
@RequestMapping("/carouts")
@CrossOrigin("*")
public class PrestationController {

	@Autowired
	private PrestationService prestationService;

	@GetMapping(value = "/prestations")
	public ResponseEntity<List<Prestation>> getAllPrestations() {
		List<Prestation> prestations = prestationService.getAllPrestations();
		return new ResponseEntity<List<Prestation>>(prestations, HttpStatus.OK);
	}

	@GetMapping(value = "/prestation/{id}")
	public ResponseEntity<Prestation> getPrestation(@PathVariable(value = "id") Long id) {
		Optional<Prestation> tategorieGet = prestationService.getPrestation(id);
		return new ResponseEntity<Prestation>(tategorieGet.get(), HttpStatus.OK);
	}

	@PutMapping("/prestation/{id}")
	public ResponseEntity<Prestation> updatePrestation(@PathVariable(value = "id") Long id,
			@RequestBody PrestationDto prestationDto) {
		Prestation prestationUpdated = prestationService.updatePrestation(id, prestationDto);
		return new ResponseEntity<Prestation>(prestationUpdated, HttpStatus.OK);
	}

	@PostMapping(value = "/prestation")
	public ResponseEntity<Prestation> addPrestation(@RequestBody Prestation prestation) {
		Prestation prestationAdded = prestationService.addPrestation(prestation);
		return new ResponseEntity<Prestation>(prestationAdded, HttpStatus.CREATED);
	}

}
