package com.lax.carouts.dto;

import java.util.Date;

public class FactureDto {

	private Long id;
	private VehiculeDto vehiculeDto;
	private PrestationDto prestationDto;
	private String label;
	private String prestataire;
	private Long kilometrageFacture;
	private Long prix;
	private Date dateFacture;

	public FactureDto() {
		super();
	}

	public FactureDto(Long id, VehiculeDto vehiculeDto, PrestationDto prestationDto, String label, String prestataire,
			Long kilometrageFacture, Long prix, Date dateFacture) {
		super();
		this.id = id;
		this.vehiculeDto = vehiculeDto;
		this.prestationDto = prestationDto;
		this.label = label;
		this.prestataire = prestataire;
		this.kilometrageFacture = kilometrageFacture;
		this.prix = prix;
		this.dateFacture = dateFacture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehiculeDto getVehiculeDto() {
		return vehiculeDto;
	}

	public void setVehiculeDto(VehiculeDto vehiculeDto) {
		this.vehiculeDto = vehiculeDto;
	}

	public PrestationDto getPrestationDto() {
		return prestationDto;
	}

	public void setPrestationDto(PrestationDto prestationDto) {
		this.prestationDto = prestationDto;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(String prestataire) {
		this.prestataire = prestataire;
	}

	public Long getkilometrageFacture() {
		return kilometrageFacture;
	}

	public void setkilometrageFacture(Long kilometrageFacture) {
		this.kilometrageFacture = kilometrageFacture;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

}
