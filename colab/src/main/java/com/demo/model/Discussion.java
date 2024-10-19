package com.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Discussion extends Superior {
	private String textMsg;
	@CreatedDate
	private Date date;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "discussion_employe",
	        joinColumns = @JoinColumn(name = "discussion_id"),
	        inverseJoinColumns = @JoinColumn(name = "employe_id")
	    )
	private List<Employe> employe=new ArrayList<>();
	
	public Discussion() {
		super();
	}
	public Discussion(String textMsg, Date date, List<Employe> employe) {
		super();
		this.textMsg = textMsg;
		this.date = date;
		this.employe = employe;
	}
	public String getTextMsg() {
		return textMsg;
	}
	public void setTextMsg(String textMsg) {
		this.textMsg = textMsg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Employe> getEmploye() {
		return employe;
	}
	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}
	
}
