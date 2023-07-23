package com.lax.carouts.mapper;

import com.lax.carouts.dto.CategorieDto;
import com.lax.carouts.model.Categorie;

public class CategorieMapper {
	
	public Categorie mapToCategorie(CategorieDto categorieDto) {
		Categorie categorie = new Categorie();
		categorie.setLabel(categorieDto.getLabel());
		return categorie;
	}

}
