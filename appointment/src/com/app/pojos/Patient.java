package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Patient")
public class Patient
{
	private Integer PId;
	@NotEmpty(message = "Name must be supplied")
	private String PName;
	
	@NotEmpty(message = "Gender is required")
	private String Gender;
	@NotEmpty(message = "Address must be supplied")
	private String PAddress;
	@NotEmpty(message = "phone no is required")
	//@Length(min = 10,max=10,message = "Invalid phone no")
	private String PhoneNumber;
	@NotEmpty(message="Email must be supplied")
	@Email(message = "Invalid email format")
	private String EmailId;
	
	private String password;
	
	private Appointment PApt;
	private Docter did;
	
	public Patient() 
	{
		System.out.println("In patient constructor");
	}




	public Patient(String pName, String gender, String pAddress, String phoneNumber, String emailId,
			String password) {
		super();
		PName = pName;
		
		Gender = gender;
		PAddress = pAddress;
		PhoneNumber = phoneNumber;
		EmailId = emailId;
		this.password = password;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPId() 
	{
		return PId;
	}


	public void setPId(Integer pId)
	{
		PId = pId;
	}

	@Column(length = 20)
	public String getPName() 
	{
		return PName;
	}


	public void setPName(String pName)
	{
		PName = pName;
	}

	
	

	@Column(length = 30)
	public String getPAddress()
	{
		return PAddress;
	}


	public void setPAddress(String pAddress)
	{
		PAddress = pAddress;
	}


	@Column(length = 10, unique = true)
	public String getPhoneNumber() {
		return PhoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}




	@Column(length = 20, unique = true)
	public String getEmailId() 
	{
		return EmailId;
	}


	public void setEmailId(String emailId)
	{
		EmailId = emailId;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "Gender")
	public String getGender() 
	{
		return Gender;
	}




	public void setGender(String gender) 
	{
		Gender = gender;
	}

	
	



	@OneToOne
	@JoinColumn(name="AID")
	public Appointment getPApt() 
	{
		return PApt;
	}




	public void setPApt(Appointment pApt) 
	{
		PApt = pApt;
	}




	@Override
	public String toString() 
	{
		return "Patient [PId=" + PId + ", PName=" + PName + ",  Gender=" + Gender + ", PAddress="
				+ PAddress + ", PhoneNumber=" + PhoneNumber + ", EmailId=" + EmailId + ", password=" + password + "]";
	}



	@ManyToOne
	@JoinColumn(name="doctorId")
	public Docter getDid() {
		return did;
	}




	public void setDid(Docter did) {
		this.did = did;
	}

	
}
