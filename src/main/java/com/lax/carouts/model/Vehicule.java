package com.lax.carouts.model;

import java.io.Serializable;

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
@Table(name = "vehicule")
@EntityListeners(AuditingEntityListener.class)
public class Vehicule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicule", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_categorie")
   private Categorie categorie;
	
	@Column(name = "label_vehicule", insertable = true, updatable = true, nullable = false)
	private String label;
	
	@Column(name = "immatriculation", insertable = true, updatable = true, nullable = false)
	private String immatriculation;
	
	@Column(name = "kilometrage", insertable = true, updatable = true, nullable = false)
	private Long kilometrage;
	
	public Vehicule() {
		super();
	}
	
	public Vehicule(Long id, Categorie categorie, String label, String immatriculation, Long kilometrage) {
		super();
		this.id = id;
		this.categorie = categorie;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
