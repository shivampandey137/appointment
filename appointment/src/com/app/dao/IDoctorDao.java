package com.app.dao;

import java.util.List;

import com.app.pojos.Docter;



public interface IDoctorDao 
{
	Docter auntheticatedoctor(String email, String pwd);
	String addNewDoctor(Docter d);
	List<Docter> listDocter();
	List<Docter> listDocterBySpecialization(String Specialization);
	Docter getdocterbyid(int id);
	
}
