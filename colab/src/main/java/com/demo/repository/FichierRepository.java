package com.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.*;
@Repository
public interface FichierRepository extends JpaRepository<Fichier, Integer> {

	Fichier findByTitre(String titre);


	
	//List<Fichier> findByDate(Date dateModidification);

}
