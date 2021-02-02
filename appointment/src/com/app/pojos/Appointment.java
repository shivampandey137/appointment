package com.app.pojos;


import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Appointment")
public class Appointment 
{
	private Integer AID;
	@NotEmpty(message = "Date is required")
	//@DateTimeFormat(pattern = "DD-MM-YYYY")
	private String date;
	//@DateTimeFormat(pattern = "hh:mm:ss")
	@NotEmpty(message = "Time is required")
	
	private String time;
	
	private Docter doc;
	private Patient AptPat; 
	
	public Appointment()
	{
		super();
		System.out.println("In Appointment constructor");
	}

	public Appointment(String date, String time)
	{
		super();
		this.date = date;
		this.time = time;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAID() 
	{
		return AID;
	}

	public void setAID(Integer aID)
	{
		AID = aID;
	}
	
	@Column(name = "ADate")
	
	public String getDate() 
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	@Column(name = "ATime")
	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}

	//owning side
			@ManyToOne
			@JoinColumn(name="DId")
		public Docter getDoc() {
			return doc;
		}

		public void setDoc(Docter doc) {
			this.doc = doc;
		}
		
		@OneToOne(mappedBy = "PApt",cascade = CascadeType.ALL)
		public Patient getAptPat() {
			return AptPat;
		}

		public void setAptPat(Patient aptPat) {
			AptPat = aptPat;
		}

		@Override
		public String toString() {
			return "Appointment [AID=" + AID + ", date=" + date + ", time=" + time + ", doc=" + doc + ", AptPat="
					+ AptPat + "]";
		}

	
	
	
	
	
	
}
