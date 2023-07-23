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

import com.lax.carouts.dto.VehiculeDto;
import com.lax.carouts.model.Vehicule;
import com.lax.carouts.service.VehiculeService;

@Controller
@RequestMapping("/carouts")
@CrossOrigin("*")
public class VehiculeController {

	@Autowired
	private VehiculeService vehiculeService;

	@GetMapping(value = "/vehicules")
	public ResponseEntity<List<Vehicule>> getAllVehicules() {
		List<Vehicule> vehicules = vehiculeService.getAllVehicules();
		return new ResponseEntity<List<Vehicule>>(vehicules, HttpStatus.OK);
	}

	@GetMapping(value = "/vehicule/{id}")
	public ResponseEntity<Vehicule> getVehicule(@PathVariable(value = "id") Long id) {
		Optional<Vehicule> tategorieGet = vehiculeService.getVehicule(id);
		return new ResponseEntity<Vehicule>(tategorieGet.get(), HttpStatus.OK);
	}

	@PutMapping("/vehicule/{id}")
	public ResponseEntity<Vehicule> updateVehicule(@PathVariable(value = "id") Long id,
			@RequestBody VehiculeDto vehiculeDto) {
		Vehicule vehiculeUpdated = vehiculeService.updateVehicule(id, vehiculeDto);
		return new ResponseEntity<Vehicule>(vehiculeUpdated, HttpStatus.OK);
	}

	@PostMapping(value = "/vehicule")
	public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
		Vehicule vehiculeAdded = vehiculeService.addVehicule(vehicule);
		return new ResponseEntity<Vehicule>(vehiculeAdded, HttpStatus.CREATED);
	}

}
