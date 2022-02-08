package com.Smart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonEntity 
{
  @Column	
  private String personName;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int personId;
  @Column
  private String personAddress;
  
  
public String getPersonName() {
	return personName;
}
public void setPersonName(String personName) {
	this.personName = personName;
}
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}
public String getPersonAddress() {
	return personAddress;
}
public void setPersonAddress(String personAddress) {
	this.personAddress = personAddress;
}
@Override
public String toString() {
	return "PersonEntity [personName=" + personName + ", personId=" + personId + ", personAddress=" + personAddress
			+ "]";
}
public PersonEntity(String personName, int personId, String personAddress) {
	super();
	this.personName = personName;
	this.personId = personId;
	this.personAddress = personAddress;
}
	
}
