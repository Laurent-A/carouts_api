package com.lax.carouts.dao;

import org.springframework.stereotype.Repository;

import com.lax.carouts.model.Vehicule;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

}
