package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointment;
import com.app.pojos.Docter;
import com.app.pojos.Patient;

@Repository
@Transactional // MANDATORY
public class PatientDaoImpl implements IPatientDao
{
	@Autowired // auto wiring by type
	private SessionFactory sf;

	@Override
	public Patient auntheticatepatient(String email, String pwd)
	{
		
			String jpql = "select P from Patient P where EmailId = :em and password=:pa";
			return sf.getCurrentSession().createQuery(jpql, Patient.class).setParameter("em", email).setParameter("pa", pwd)
					.getSingleResult();
	}

	

	@Override
	public String addNewPatient(Patient p) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(p);//v --persistent
		return "Patient registered successfully : ID "+p.getPId();
		
	}



	@Override
	public List<Patient> listPatient(int did) {
		// TODO Auto-generated method stub
		String jpql = "select P from Patient P where P.did.DId=:did";
		List<Patient> l= sf.getCurrentSession().createQuery(jpql, Patient.class).setParameter("did", did).getResultList();
		//System.out.println(l);
		return l;
	}



	@Override
	public List<Docter> GetAllDocter() {
		// TODO Auto-generated method stub
		String jpql = "select d from Docter d ";
		List<Docter> ll= sf.getCurrentSession().createQuery(jpql, Docter.class).getResultList();
		//System.out.println(ll);
		return ll;
	}



	@Override
	public String addappointment(Appointment a) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(a);//v --persistent
		return "Appointment added successfully : ID "+a.getAID();
		
	}
	
	
	@Override
	public String deleteappointment(int aid) {
		Session hs = sf.getCurrentSession();
		Appointment a = hs.get(Appointment.class, aid);
		System.out.println(a);
		if (a != null) {
			hs.delete(a);
			return "Appointment cancelled with ID " + a.getAID();
		}
		return "Appointment deletion failed : Invalid Appointment ID";
	}



	@Override
	public String updateDId(Docter d,Appointment a1,Patient p) {
		// TODO Auto-generated method stub
		p.setDid(d);
		p.setPApt(a1);
		
		sf.getCurrentSession().update(p);
		return "updated";
	}



	@Override
	public Appointment getApootintmnetByDid(int did) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("select a from Appointment a where a.doc.DId=:did", Appointment.class).setParameter("did", did).getSingleResult();
	}



}
