package com.lax.carouts.service;

import java.util.List;
import java.util.Optional;

import com.lax.carouts.dto.FactureDto;
import com.lax.carouts.exception.ApiNotFoundException;
import com.lax.carouts.model.Facture;

public interface FactureService {

	List<Facture> getAllFactures();

	Optional<Facture> getFacture(Long id) throws ApiNotFoundException;

	Facture updateFacture(Long id, FactureDto factureDto) throws ApiNotFoundException;

	Facture addFacture(Facture facture) throws ApiNotFoundException;

}
