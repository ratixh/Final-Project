package com.smart.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
	
	@NotBlank(message = "Name field is required !!")
	@Size(min=2 ,max=20,message="min 2 and max 20 characters are allowed !!")
	private String userName;
	
	@Column(unique = true)
	private String userEmail;
	
	
	private String userPassword;
	
	
	private String userRole;
	

	private String userImage;
	
	
	private String enabled;
	
	@Column(length = 500)
	private String userAbout;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Contact> contact = new ArrayList<>();
	
	

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userRole=" + userRole + ", userImage=" + userImage + ", enabled=" + enabled
				+ ", userAbout=" + userAbout + ", contact=" + contact + "]";
	}

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
