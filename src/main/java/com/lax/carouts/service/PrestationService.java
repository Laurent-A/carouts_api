package com.lax.carouts.service;

import java.util.List;
import java.util.Optional;

import com.lax.carouts.dto.PrestationDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.model.Prestation;

public interface PrestationService {

	List<Prestation> getAllPrestations();

	Optional<Prestation> getPrestation(Long id) throws ApiNotFoundException;

	Prestation updatePrestation(Long id, PrestationDto prestationDto) throws ApiNotFoundException;

	Prestation addPrestation(Prestation prestation) throws ApiNotFoundException;

}
