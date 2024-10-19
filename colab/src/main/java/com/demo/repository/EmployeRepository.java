package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer>{
    Employe findByNom(String nom);


	Employe findByMailAndMdp(String mail, String mdp);


}
