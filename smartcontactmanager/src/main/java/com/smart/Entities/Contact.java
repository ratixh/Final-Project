package com.smart.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Contact")
public class Contact
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int contactid;
  
   @Column
   private int contactName;
   
   @Column
   private int contactNickname;
   
   @Column
   private int contactPhone;
   
   @Column
   private int contactWork;
   
   @Column
   private int contactEmail;
   
   @Column
   private int contactImage;
   
   @Column(length = 1000)
   private int contactDescription;
   
   @ManyToOne(cascade = CascadeType.ALL)
   private User user;
   

public User getUserclass() {
	return user;
}

public void setUserclass(User userclass) {
	this.user = user;
}

public int getContactid() {
	return contactid;
}

public void setContactid(int contactid) {
	this.contactid = contactid;
}

public int getContactName() {
	return contactName;
}

public void setContactName(int contactName) {
	this.contactName = contactName;
}

public int getContactNickname() {
	return contactNickname;
}

public void setContactNickname(int contactNickname) {
	this.contactNickname = contactNickname;
}

public int getContactPhone() {
	return contactPhone;
}

public void setContactPhone(int contactPhone) {
	this.contactPhone = contactPhone;
}

public int getContactWork() {
	return contactWork;
}

public void setContactWork(int contactWork) {
	this.contactWork = contactWork;
}

public int getContactEmail() {
	return contactEmail;
}

public void setContactEmail(int contactEmail) {
	this.contactEmail = contactEmail;
}

public int getContactImage() {
	return contactImage;
}

public void setContactImage(int contactImage) {
	this.contactImage = contactImage;
}

public int getContactDescription() {
	return contactDescription;
}

public void setContactDescription(int contactDescription) {
	this.contactDescription = contactDescription;
}
   
   
   
   
}
