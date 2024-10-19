package com.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employe;
import com.demo.model.Projet;
@Repository
public interface ProjetRepository  extends JpaRepository<Projet, Integer>{

	Projet findByTitre(String titre);

	//Projet findByDate(Date dateModidification);

}
