package com.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity 
public class Projet extends Superior {
	private String titre;
	private Date dateModification;
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date datePublication;
	@ManyToMany(fetch = FetchType.LAZY)
	   @JoinTable(
		        name = "projet_employe",
		        joinColumns = @JoinColumn(name = "projet_id"),
		        inverseJoinColumns = @JoinColumn(name = "employe_id")
		    )
	private List<Employe> employe=new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="id_chef")
	private ChefEquipe chef;
	
	public Projet() {
		super();
	}
	public Projet(String titre, Date dateModification, Date datePublication, List<Employe> employe, ChefEquipe chef) {
		super();
		this.titre = titre;
		this.dateModification = dateModification;
		this.datePublication = datePublication;
		this.employe = employe;
		this.chef = chef;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	public List<Employe> getEmploye() {
		return employe;
	}
	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}
	public ChefEquipe getChef() {
		return chef;
	}
	public void setChef(ChefEquipe chef) {
		this.chef = chef;
	}
	
}
