package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.demo.controller.EmployeController;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employe extends Superior{
@Column(nullable = false)
private String nom,prenom,grade,adresse;
private String mail;
private String mdp;
@Column(length = 8)
private String numtel;
@ManyToMany(mappedBy = "employe",fetch = FetchType.LAZY)
private List<Projet> projet=new ArrayList<>() ;
@ManyToMany(mappedBy = "employe",fetch = FetchType.LAZY)
private List<Discussion> discussion=new ArrayList<>();
public Employe(String nom, String prenom, String mail, String mdp, String numtel,String grade,String adresse) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.adresse=adresse;
	this.mail = mail;
	this.mdp = mdp;
	this.numtel = numtel;
	this.grade=grade;
}


public String getAdresse() {
	return adresse;
}


public void setAdresse(String adresse) {
	this.adresse = adresse;
}


public String getGrade() {
	return grade;
}


public void setGrade(String grade) {
	this.grade = grade;
}


public Employe() {
	super();
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getMdp() {
	return mdp;
}

public void setMdp(String mdp) {
	this.mdp = mdp;
}

public String getNumtel() {
	return numtel;
}

public void setNumtel(String numtel) {
	this.numtel = numtel;
}

public List<Projet> getProjet() {
	return projet;
}

public void setProjet(List<Projet> projet) {
	this.projet = projet;
}

public List<Discussion> getDiscussion() {
	return discussion;
}

public void setDiscussion(List<Discussion> discussion) {
	this.discussion = discussion;
}



}
