package com.example.PlacementManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class College {
	
@Id
private int id;
private String collegeAdmin;
private String collegeName;
private String location;


public College(int id, String collegeAdmin, String collegeName, String location) {
	super();
	this.id = id;
	this.collegeAdmin = collegeAdmin;
	this.collegeName = collegeName;
	this.location = location;
}

public College() {
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCollegeAdmin() {
	return collegeAdmin;
}
public void setCollegeAdmin(String collegeAdmin) {
	this.collegeAdmin = collegeAdmin;
}
public String getCollegeName() {
	return collegeName;
}
public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "College [id=" + id + ", collegeAdmin=" + collegeAdmin + ", collegeName=" + collegeName + ", location="
			+ location + "]";
}


}
