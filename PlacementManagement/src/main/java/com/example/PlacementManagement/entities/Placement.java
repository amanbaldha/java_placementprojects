package com.example.PlacementManagement.entities;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Placement {
	
@Id
private int id;
private String name;
private String college;
private Date date;
private String qualification;
private int year;

public Placement(int id, String name, String college, Date date, String qualification, int year) {
	super();
	this.id = id;
	this.name = name;
	this.college = college;
	this.date = date;
	this.qualification = qualification;
	this.year = year;
}

public Placement() {
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
@Override
public String toString() {
	return "Placement [id=" + id + ", name=" + name + ", college=" + college + ", date=" + date + ", qualification="
			+ qualification + ", year=" + year + "]";
}


}
