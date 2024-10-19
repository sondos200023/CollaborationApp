package com.demo.controller;

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

import com.demo.model.Employe;
import com.demo.repository.EmployeRepository;

@RestController
@RequestMapping("employe")
public class EmployeController {
	@Autowired
	EmployeRepository employeRepository;
	@PostMapping
	public Employe addOne(@RequestBody Employe employee)
	{
		return employeRepository.save(employee);
	}
	@GetMapping
	public List<Employe> getAll()
	{
		return employeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employe getOneByid(@PathVariable int id)
	{
		return employeRepository.findById(id).get();
	}
	@GetMapping("/{nom}/{prenom}")
	public Employe getOneByNomPrenom(@PathVariable String nom)
	{
        return employeRepository.findByNom(nom);
	}
	@PutMapping("/employé/{id}")
	public void update(@RequestBody Employe updatedEmployee,@PathVariable int id) {
	        Optional<Employe> employee = employeRepository.findById(id);
	        if (employee.isPresent()) {
	            Employe existingEmployee = employee.get();
	            existingEmployee.setNom(updatedEmployee.getNom());
	            existingEmployee.setPrenom(updatedEmployee.getPrenom());
	            existingEmployee.setMail(updatedEmployee.getMail());
	            existingEmployee.setMdp(updatedEmployee.getMdp());
	            existingEmployee.setNumtel(updatedEmployee.getNumtel()); 	

	           employeRepository.save(existingEmployee);
	   }
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable int id)
	{
		employeRepository.deleteById(id);
	}
	@GetMapping("/{email}/{mdp}")
	public Employe findByMailAndMdp(@PathVariable String mail,@PathVariable String mdp)
	{
        return employeRepository.findByMailAndMdp(mail, mdp);
	}
}
