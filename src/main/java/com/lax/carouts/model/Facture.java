package com.lax.carouts.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "facture")
@EntityListeners(AuditingEntityListener.class)
public class Facture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_facture", updatable = false, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private Vehicule vehicule;

	@ManyToOne
	@JoinColumn(name = "id_prestation")
	private Prestation prestation;

	@Column(name = "label_facture", insertable = true, updatable = true, nullable = false)
	private String label;

	@Column(name = "prix", insertable = true, updatable = true, nullable = false)
	private Long prix;

	@Column(name = "kilometrage", insertable = true, updatable = true, nullable = false)
	private Long kilometrage;
	
	@Column(name = "date_facture", insertable = true, updatable = true, nullable = false)
	private Date dateFacture;

	public Facture() {
		super();
	}

	public Facture(Long id, Vehicule vehicule, Prestation prestation, String label, Long prix, Long kilometrage,
			Date dateFacture) {
		super();
		this.id = id;
		this.vehicule = vehicule;
		this.prestation = prestation;
		this.label = label;
		this.prix = prix;
		this.kilometrage = kilometrage;
		this.dateFacture = dateFacture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Long getKilometrage() {
		return kilometrage;
	}

	public void setkilometrageFacture(Long kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
