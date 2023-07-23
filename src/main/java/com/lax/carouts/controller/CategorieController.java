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

import com.lax.carouts.dto.CategorieDto;
import com.lax.carouts.model.Categorie;
import com.lax.carouts.service.CategorieService;

@Controller
@RequestMapping("/carouts")
@CrossOrigin("*")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;

	@GetMapping(value = "/categories")
	public ResponseEntity<List<Categorie>> getAllCategories() {
		List<Categorie> categories = categorieService.getAllCategories();
		return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
	}

	@GetMapping(value = "/categorie/{id}")
	public ResponseEntity<Categorie> getCategorie(@PathVariable(value = "id") Long id) {
		Optional<Categorie> tategorieGet = categorieService.getCategorie(id);
		return new ResponseEntity<Categorie>(tategorieGet.get(), HttpStatus.OK);
	}

	@PutMapping("/categorie/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long id,
			@RequestBody CategorieDto categorieDto) {
		Categorie categorieUpdated = categorieService.updateCategorie(id, categorieDto);
		return new ResponseEntity<Categorie>(categorieUpdated, HttpStatus.OK);
	}

	@PostMapping(value = "/categorie")
	public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
		Categorie categorieAdded = categorieService.addCategorie(categorie);
		return new ResponseEntity<Categorie>(categorieAdded, HttpStatus.CREATED);
	}

}
