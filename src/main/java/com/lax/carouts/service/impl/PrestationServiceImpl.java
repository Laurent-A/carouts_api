package com.lax.carouts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lax.carouts.dao.PrestationRepository;
import com.lax.carouts.dto.PrestationDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.model.Prestation;
import com.lax.carouts.service.PrestationService;

import jakarta.transaction.Transactional;

@Service
public class PrestationServiceImpl implements PrestationService {

	@Autowired
	private PrestationRepository prestationRepository;

	public PrestationServiceImpl() {
		super();
	}

	@Override
	public List<Prestation> getAllPrestations() {
		return this.prestationRepository.findAll();
	}

	@Override
	public Optional<Prestation> getPrestation(Long id) throws ApiNotFoundException {

		Optional<Prestation> prestationFound = prestationRepository.findById(id);
		if (Boolean.FALSE.equals(prestationFound.isPresent())) {
			throw new ApiNotFoundException("Prestation", "id :", id);
		}
		return prestationFound;
	}

	@Transactional
	@Override
	public Prestation updatePrestation(Long id, PrestationDto prestationDto) throws ApiNotFoundException {
		Prestation prestation = this.getPrestation(id)
				.orElseThrow(() -> new ApiNotFoundException("Prestation", "id", id));

		prestation.setLabel(prestationDto.getLabel());

		try {
			prestationRepository.save(prestation);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Modification impossible", "Erreur : ", e);
		}
		return prestation;
	}

	@Transactional
	@Override
	public Prestation addPrestation(Prestation prestation) throws ApiNotFoundException {
		try {
			prestationRepository.save(prestation);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Enregistrement impossible", "Erreur : ", e);
		}
		return prestation;
	}

}
