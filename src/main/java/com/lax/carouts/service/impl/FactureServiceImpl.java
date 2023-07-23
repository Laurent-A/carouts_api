package com.lax.carouts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lax.carouts.dao.FactureRepository;
import com.lax.carouts.dto.FactureDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.mapper.PrestationMapper;
import com.lax.carouts.mapper.VehiculeMapper;
import com.lax.carouts.model.Facture;
import com.lax.carouts.service.FactureService;
import jakarta.transaction.Transactional;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureRepository factureRepository;

	private VehiculeMapper vehiculeMapper;

	private PrestationMapper prestationMapper;

	public FactureServiceImpl() {
		super();
	}

	@Override
	public List<Facture> getAllFactures() {
		return this.factureRepository.findAll();
	}

	@Override
	public Optional<Facture> getFacture(Long id) throws ApiNotFoundException {

		Optional<Facture> factureFound = factureRepository.findById(id);
		if (Boolean.FALSE.equals(factureFound.isPresent())) {
			throw new ApiNotFoundException("Facture", "id :", id);
		}
		return factureFound;
	}

	@Transactional
	@Override
	public Facture updateFacture(Long id, FactureDto factureDto) throws ApiNotFoundException {
		Facture facture = this.getFacture(id).orElseThrow(() -> new ApiNotFoundException("Facture", "id", id));

		facture.setLabel(factureDto.getLabel());
		facture.setPrix(factureDto.getPrix());
		facture.setDateFacture(factureDto.getDateFacture());
		facture.setVehicule(vehiculeMapper.mapToVehicule(factureDto.getVehiculeDto()));
		facture.setPrestation(prestationMapper.mapToPrestation(factureDto.getPrestationDto()));
		facture.setkilometrageFacture(factureDto.getkilometrageFacture());

		try {
			factureRepository.save(facture);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Modification impossible", "Erreur : ", e);
		}
		return facture;
	}

	@Transactional
	@Override
	public Facture addFacture(Facture facture) throws ApiNotFoundException {
		try {
			factureRepository.save(facture);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Enregistrement impossible", "Erreur : ", e);
		}
		return facture;
	}

}
