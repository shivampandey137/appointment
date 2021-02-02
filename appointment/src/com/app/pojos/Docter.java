package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Docter")
public class Docter 
{
	private Integer DId;
	@NotEmpty(message = "Name must be supplied")
	private String Dname;
	@NotEmpty(message = "Gender must be supplied")
	private String Gender;
	
	@NotEmpty(message = "Qualification must be supplied")
	private String Qualification;
	@NotEmpty(message = " Specialization must be supplied")
	private String Specialization;
	@NotEmpty(message = "Address must be supplied")
	private String Daddress;
	@NotEmpty(message = "phone no is required")
	@Length(min = 10,max=10,message = "Invalid phone no")
	private String PhoneNumber;
	@NotEmpty(message="Email must be supplied")
	//@Email(message = "Invalid email format")
	private String EmailId;
	@NotEmpty
	private String password;
	
	private List<Patient> lofPatient =new ArrayList<>();
	
	private List<Appointment> listofApt=new ArrayList<>() ;
	
	public Docter() 
	{
		System.out.println("In Docter constructor");
	}

		
	

	




	public Docter(String dname, String gender,String qualification, String specialization,
			String daddress, String phoneNumber, String emailId, String password, List<Patient> lofPatient,
			List<Appointment> listofApt) {
		super();
		Dname = dname;
		Gender = gender;
		
		
		Qualification = qualification;
		Specialization = specialization;
		Daddress = daddress;
		PhoneNumber = phoneNumber;
		EmailId = emailId;
		this.password = password;
		this.lofPatient = lofPatient;
		this.listofApt = listofApt;
	}









	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDId() 
	{
		return DId;
	}

	public void setDId(Integer dId)
	{
		DId = dId;
	}
	
	@Column(length = 10)
	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Column(length = 20)
	public String getDname() 
	{
		return Dname;
	}

	public void setDname(String dname)
	{
		Dname = dname;
	}
	
	@Column(length = 20)
	public String getQualification() 
	{
		return Qualification;
	}

	public void setQualification(String qualification) 
	{
		Qualification = qualification;
	}

	@Column(length = 20)
	public String getSpecialization()
	{
		return Specialization;
	}

	public void setSpecialization(String specialization)
	{
		Specialization = specialization;
	}

	@Column(length = 20)
	public String getDaddress()
	{
		return Daddress;
	}

	public void setDaddress(String daddress) 
	{
		Daddress = daddress;
	}

	@Column(length = 10, unique = true)
	public String getPhoneNumber() 
	{
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
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

	@Column(name = "Gender")
	public String getGender() 
	{
		return Gender;
	}



	
	public void setGender(String gender) 
	{
		Gender = gender;
	}



	


	/*
	 * @Column(name = "DOB") public Date getDob() { return Dob; }
	 * 
	 * 
	 * 
	 * 
	 * public void setDob(Date dob) { Dob = dob; }
	 */


    @LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "did",cascade = CascadeType.ALL)
	public List<Patient> getLofPatient() {
		return lofPatient;
	}


	public void setLofPatient(List<Patient> lofPatient) {
		this.lofPatient = lofPatient;
	}

    @LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "doc",cascade = CascadeType.ALL)
	public List<Appointment> getListofApt()
	{
		return listofApt;
	}

	public void setListofApt(List<Appointment> listofApt)
	{
		this.listofApt = listofApt;
	}


	@Override
	public String toString() {
		return "Docter [DId=" + DId + ", Dname=" + Dname + ", Gender=" + Gender + ", Qualification=" + Qualification
				+ ", Specialization=" + Specialization + ", Daddress=" + Daddress + ", PhoneNumber=" + PhoneNumber
				+ ", EmailId=" + EmailId + ", password=" + password+"]";/*+ ", lofPatient=" + lofPatient + ", listofApt="
				+ listofApt + "]";*/
	}






	


	
	
	
	
	
	
	
	
	

}
