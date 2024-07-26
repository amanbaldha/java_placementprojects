package com.example.PlacementManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Certificate {

@Id
private int id;
private int year;
private String college;

public Certificate(int id, int year, String college) {
	super();
	this.id = id;
	this.year = year;
	this.college = college;
}

public Certificate() {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public String getCollege() {
	return college;
}

public void setCollege(String college) {
	this.college = college;
}

@Override
public String toString() {
	return "Certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
}



}
