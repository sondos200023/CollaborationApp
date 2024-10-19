package com.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.*;
import com.demo.repository.*;
@RestController
@RequestMapping("Projet")
public class ProjetController {
	@Autowired
	ProjetRepository ProjetRepository;
	@PostMapping
	public Projet addOne(@RequestBody Projet projet)
	{
		return ProjetRepository.save(projet);
	}
	@GetMapping
	public List<Projet> getAll()
	{
		return ProjetRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Projet getOne(@PathVariable int id)
	{
		return ProjetRepository.findById(id).get();
	}
	@GetMapping("/{titre}")
	public Projet getOneByTitre(@PathVariable String titre)
	{        return ProjetRepository.findByTitre(titre);
	}
	/*@GetMapping("/{dateModification}")
	public Projet getOneByDate(@RequestBody Date dateModidification)
	{
        return ProjetRepository.findByDate(dateModidification);
	}*/
	@PutMapping("/Projet/{id}")
	public void update(@RequestBody Projet updatedProjet,@PathVariable int id) {
	        Optional<Projet> Projet = ProjetRepository.findById(id);
	        if (Projet.isPresent()) {
	            Projet existingProjet = Projet.get();
	            existingProjet.setTitre(updatedProjet.getTitre());
	            existingProjet.setDateModification(updatedProjet.getDateModification());
	            existingProjet.setDatePublication(updatedProjet.getDatePublication());
	            existingProjet.setEmploye(updatedProjet.getEmploye());
	            existingProjet.setChef(updatedProjet.getChef()); 	

	           ProjetRepository.save(updatedProjet);
	   }}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable int id)
	{
		ProjetRepository .deleteById(id);
	}
}
