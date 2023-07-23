package com.lax.carouts.dao;

import org.springframework.stereotype.Repository;

import com.lax.carouts.model.Facture;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
