package com.lax.carouts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lax.carouts.dao.CategorieRepository;
import com.lax.carouts.dto.CategorieDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.model.Categorie;
import com.lax.carouts.service.CategorieService;

import jakarta.transaction.Transactional;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieRepository categorieRepository;

	public CategorieServiceImpl() {
		super();
	}

	@Override
	public List<Categorie> getAllCategories() {
		return this.categorieRepository.findAll();
	}

	@Override
	public Optional<Categorie> getCategorie(Long id) throws ApiNotFoundException {

		Optional<Categorie> categorieFound = categorieRepository.findById(id);
		if (Boolean.FALSE.equals(categorieFound.isPresent())) {
			throw new ApiNotFoundException("Categorie", "id :", id);
		}
		return categorieFound;
	}

	@Transactional
	@Override
	public Categorie updateCategorie(Long id, CategorieDto categorieDto) throws ApiNotFoundException {
		Categorie categorie = this.getCategorie(id).orElseThrow(() -> new ApiNotFoundException("Categorie", "id", id));

		categorie.setLabel(categorieDto.getLabel());

		try {
			categorieRepository.save(categorie);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Modification impossible", "Erreur : ", e);
		}
		return categorie;
	}

	@Transactional
	@Override
	public Categorie addCategorie(Categorie categorie) throws ApiNotFoundException {
		try {
			categorieRepository.save(categorie);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Enregistrement impossible", "Erreur : ", e);
		}
		return categorie;
	}

}
