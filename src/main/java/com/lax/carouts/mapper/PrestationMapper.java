package com.lax.carouts.mapper;

import com.lax.carouts.dto.PrestationDto;
import com.lax.carouts.model.Prestation;

public class PrestationMapper {
	
	public Prestation mapToPrestation(PrestationDto prestationDto) {
		Prestation prestation = new Prestation();
		prestation.setLabel(prestationDto.getLabel());
		return prestation;
	}

}
