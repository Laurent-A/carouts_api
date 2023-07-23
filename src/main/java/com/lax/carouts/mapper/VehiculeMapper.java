package com.lax.carouts.mapper;

import com.lax.carouts.dto.VehiculeDto;
import com.lax.carouts.model.Vehicule;

public class VehiculeMapper {
	
	private CategorieMapper categorieMapper;
	
	public Vehicule mapToVehicule(VehiculeDto vehiculeDto) {
		Vehicule vehicule = new Vehicule();
		vehicule.setLabel(vehiculeDto.getLabel());
		vehicule.setImmatriculation(vehiculeDto.getImmatriculation());
		vehicule.setKilometrage(vehiculeDto.getKilometrage());
		vehicule.setCategorie(categorieMapper.mapToCategorie(vehiculeDto.getCategorieDto()));
		return vehicule;
	}

}
