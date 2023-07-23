package com.lax.carouts.service;

import java.util.List;
import java.util.Optional;

import com.lax.carouts.dto.CategorieDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.model.Categorie;

public interface CategorieService {

	List<Categorie> getAllCategories();

	Optional<Categorie> getCategorie(Long id) throws ApiNotFoundException;

	Categorie updateCategorie(Long id, CategorieDto todoDto) throws ApiNotFoundException;

	Categorie addCategorie(Categorie categorie) throws ApiNotFoundException;

}
