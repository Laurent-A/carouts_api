package com.lax.carouts.dto;

public class VehiculeDto {

	private Long id;
	private CategorieDto categorieDto;
	private String label;
	private String immatriculation;
	private Long kilometrage;
	
	public VehiculeDto() {
		super();
	}
	
	public VehiculeDto(Long id, CategorieDto categorieDto, String label, String immatriculation, Long kilometrage) {
		super();
		this.id = id;
		this.categorieDto = categorieDto;
		this.label = label;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategorieDto getCategorieDto() {
		return categorieDto;
	}

	public void setCategorieDto(CategorieDto categorie) {
		this.categorieDto = categorie;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Long getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Long kilometrage) {
		this.kilometrage = kilometrage;
	}
	
}
