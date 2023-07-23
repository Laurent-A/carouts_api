package com.lax.carouts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lax.carouts.model.Prestation;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long>{

}
