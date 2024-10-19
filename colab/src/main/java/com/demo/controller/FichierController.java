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
@RequestMapping("Fichier")
public class FichierController {
	@Autowired
	FichierRepository FichierRepository;
	@PostMapping
	public Fichier addOne(@RequestBody Fichier Fichier)
	{
		return FichierRepository.save(Fichier);
	}
	@GetMapping
	public List<Fichier> getAll()
	{
		return FichierRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Fichier getOne(@PathVariable int id)
	{
		return FichierRepository.findById(id).get();
	}
	@GetMapping("/{titre}")
	public Fichier getOneByTitre(@PathVariable String titre)
	{        return FichierRepository.findByTitre(titre);
	}
	/*@GetMapping("/{dateModification}")
	public List<Fichier> getByDate(@RequestBody Date dateModidification)
	{
        return FichierRepository.findByDate(dateModidification);
	}*/
	@PutMapping("/Fichier/{id}")
	public void update(@RequestBody Fichier updatedFichier,@PathVariable int id) {
	        Optional<Fichier> fichierr = FichierRepository.findById(id);
	        if (fichierr.isPresent()) {
	            Fichier existingFichier = fichierr.get();
	            existingFichier.setDescription(updatedFichier.getDescription());
	            existingFichier.setDateModification(updatedFichier.getDateModification());
	            existingFichier.setDatePublication(updatedFichier.getDatePublication());
	            existingFichier.setTitre(updatedFichier.getTitre());
	            existingFichier.setChef(updatedFichier.getChef()); 	

	           FichierRepository.save(existingFichier);
	   }}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable int id)
	{
		FichierRepository .deleteById(id);
	}
}

