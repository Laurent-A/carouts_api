package com.lax.carouts.service;

import java.util.List;
import java.util.Optional;

import com.lax.carouts.dto.VehiculeDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.model.Vehicule;

public interface VehiculeService {

	List<Vehicule> getAllVehicules();

	Optional<Vehicule> getVehicule(Long id) throws ApiNotFoundException;

	Vehicule updateVehicule(Long id, VehiculeDto vehiculeDto) throws ApiNotFoundException;

	Vehicule addVehicule(Vehicule vehicule) throws ApiNotFoundException;

}
