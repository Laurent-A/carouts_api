package com.lax.carouts.dao;

import org.springframework.stereotype.Repository;

import com.lax.carouts.model.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
