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

import com.lax.carouts.dto.FactureDto;
import com.lax.carouts.model.Facture;
import com.lax.carouts.service.FactureService;

@Controller
@RequestMapping("/carouts")
@CrossOrigin("*")
public class FactureController {

	@Autowired
	private FactureService factureService;

	@GetMapping(value = "/factures")
	public ResponseEntity<List<Facture>> getAllFactures() {
		List<Facture> factures = factureService.getAllFactures();
		return new ResponseEntity<List<Facture>>(factures, HttpStatus.OK);
	}

	@GetMapping(value = "/facture/{id}")
	public ResponseEntity<Facture> getFacture(@PathVariable(value = "id") Long id) {
		Optional<Facture> tategorieGet = factureService.getFacture(id);
		return new ResponseEntity<Facture>(tategorieGet.get(), HttpStatus.OK);
	}

	@PutMapping("/facture/{id}")
	public ResponseEntity<Facture> updateFacture(@PathVariable(value = "id") Long id,
			@RequestBody FactureDto factureDto) {
		Facture factureUpdated = factureService.updateFacture(id, factureDto);
		return new ResponseEntity<Facture>(factureUpdated, HttpStatus.OK);
	}

	@PostMapping(value = "/facture")
	public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
		Facture factureAdded = factureService.addFacture(facture);
		return new ResponseEntity<Facture>(factureAdded, HttpStatus.CREATED);
	}

}
