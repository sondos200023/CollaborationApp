package com.demo.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fichier extends Superior{
private String description,titre;
@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
private Date dateModification;
@Temporal(TemporalType.TIMESTAMP)
@CreatedDate
private Date datePublication;
@ManyToOne(fetch = FetchType.LAZY,optional = false)
@JoinColumn(name ="id_chef")
private ChefEquipe chef;

public Fichier(String description, String titre, Date dateModification, Date datePublication) {
	super();
	this.description = description;
	this.titre = titre;
	this.dateModification = dateModification;
	this.datePublication = datePublication;
}

public Fichier(String description, String titre, Date dateModification, Date datePublication, ChefEquipe chef) {
	super();
	this.description = description;
	this.titre = titre;
	this.dateModification = dateModification;
	this.datePublication = datePublication;
	this.chef = chef;
}

public Fichier() {
	super();
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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
public ChefEquipe getChef() {
	return chef;
}
public void setChef(ChefEquipe chef) {
	this.chef = chef;
}

}
