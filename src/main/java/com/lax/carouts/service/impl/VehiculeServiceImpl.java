package com.lax.carouts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lax.carouts.dao.VehiculeRepository;
import com.lax.carouts.dto.VehiculeDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.mapper.CategorieMapper;
import com.lax.carouts.model.Vehicule;
import com.lax.carouts.service.VehiculeService;
import jakarta.transaction.Transactional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	private CategorieMapper categorieMapper;

	public VehiculeServiceImpl() {
		super();
	}

	@Override
	public List<Vehicule> getAllVehicules() {
		return this.vehiculeRepository.findAll();
	}

	@Override
	public Optional<Vehicule> getVehicule(Long id) throws ApiNotFoundException {

		Optional<Vehicule> vehiculeFound = vehiculeRepository.findById(id);
		if (Boolean.FALSE.equals(vehiculeFound.isPresent())) {
			throw new ApiNotFoundException("Vehicule", "id :", id);
		}
		return vehiculeFound;
	}

	@Transactional
	@Override
	public Vehicule updateVehicule(Long id, VehiculeDto vehiculeDto) throws ApiNotFoundException {
		Vehicule vehicule = this.getVehicule(id).orElseThrow(() -> new ApiNotFoundException("Vehicule", "id", id));

		vehicule.setLabel(vehiculeDto.getLabel());
		vehicule.setImmatriculation(vehiculeDto.getImmatriculation());
		vehicule.setKilometrage(vehiculeDto.getKilometrage());
		vehicule.setCategorie(categorieMapper.mapToCategorie(vehiculeDto.getCategorieDto()));
		
		try {
			vehiculeRepository.save(vehicule);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Modification impossible", "Erreur : ", e);
		}
		return vehicule;
	}

	@Transactional
	@Override
	public Vehicule addVehicule(Vehicule vehicule) throws ApiNotFoundException {
		try {
			vehiculeRepository.save(vehicule);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Enregistrement impossible", "Erreur : ", e);
		}
		return vehicule;
	}

}
