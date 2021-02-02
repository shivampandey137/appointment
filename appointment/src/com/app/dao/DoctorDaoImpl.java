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
public class DoctorDaoImpl  implements IDoctorDao{
	@Autowired // auto wiring by type
	private SessionFactory sf;
	
	
	@Override
	public Docter auntheticatedoctor(String email, String pwd) {
		String jpql = "select d from Docter d where EmailId=:em and password=:pa";
		Docter d= sf.getCurrentSession().createQuery(jpql, Docter.class).setParameter("em", email).setParameter("pa", pwd).getSingleResult();
		System.out.println(d);
		return d;
	}


	@Override
	public String addNewDoctor(Docter d) {
		
		sf.getCurrentSession().persist(d);//v --persistent
		return "Doctor registered successfully : ID "+d.getDId();
		
	}


	@Override
	public List<Docter> listDocter() {
		// TODO Auto-generated method stub
		String jpql = "select d from Docter d ";
		List<Docter> ll= sf.getCurrentSession().createQuery(jpql, Docter.class).getResultList();
		//System.out.println(ll);
		return ll;
		
	}


	@Override
	public List<Docter> listDocterBySpecialization(String Specialization) {
		// TODO Auto-generated method stub
		String jpql = "select d from Docter d where Specialization=:Specialization";
		List<Docter> ll= sf.getCurrentSession().createQuery(jpql, Docter.class).setParameter("Specialization", Specialization).getResultList();
		//System.out.println(ll);
		return ll;
	}


	@Override
	public Docter getdocterbyid(int id) {
		// TODO Auto-generated method stub
		
		return sf.getCurrentSession().get(Docter.class, id);
	}


	/*@Override
	public String deleteappointment(int aid) {
		Session hs = sf.getCurrentSession();
		Appointment a = hs.get(Appointment.class, aid);
		if (a != null) {
			hs.delete(a);
			return "Appointment cancelled with ID " + a.getAID();
		}
		return "Appointment deletion failed : Invalid Appointment ID";
	}*/

}




