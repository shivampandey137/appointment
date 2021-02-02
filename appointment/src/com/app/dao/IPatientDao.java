package com.app.dao;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Docter;
import com.app.pojos.Patient;

public interface IPatientDao
{
	Patient auntheticatepatient(String email, String pwd);
	String addNewPatient(Patient P);
	List<Patient> listPatient(int did);
	List<Docter> GetAllDocter();
	String addappointment(Appointment a);
	String deleteappointment(int aid);
	
	String updateDId(Docter d,Appointment a,Patient p);
	
	Appointment getApootintmnetByDid(int did);
}
