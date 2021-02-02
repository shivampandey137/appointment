package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IDoctorDao;
import com.app.dao.IPatientDao;
import com.app.pojos.Docter;
import com.app.pojos.Patient;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

	
	@Autowired // auto wiring by type
	private IDoctorDao dao;

	
	@Autowired // auto wiring by type
	private IPatientDao pdao;

	public DoctorController()
	{
		//System.out.println("in Doctor controller constr");
	}

	// request handling method to show login form
		@GetMapping("/login")
		public String showLoginForm() 
		{
			//System.out.println("in show Doctor login form");
			return "/doctor/login";
		}

	// request handling method to process login form	
		@PostMapping("/login")
		public String processLoginForm(@RequestParam String em,
				@RequestParam String pass, Model map,
				RedirectAttributes flashMap, HttpSession hs)
		{
			//System.out.println("in Doctor login form");
			// invoke dao's method for auth.
			
			try 
			{
				Docter D= dao.auntheticatedoctor(em, pass);
				// valid login
				hs.setAttribute("doctor_dtls", D);// till logout
				flashMap.addFlashAttribute("mesg", "Login Successful");// till next request
				return "redirect:/doctor/details";
				
			} 
			catch (RuntimeException e)
			{
				//System.out.println("error in controller " + e);
				//System.out.println(D);
				map.addAttribute("mesg", "Invalid Login");
				// invalid login
				return "/doctor/login";
			}

			
		}
		
		@GetMapping("/details")
		public String welcome(HttpSession hs) 
		{
			Docter d=(Docter)hs.getAttribute("doctor_dtls");
		List<Patient> pl=pdao.listPatient(d.getDId());
			hs.setAttribute("p_list",pl);
			System.out.println(pl);
			if(pl.size()>0)
			{
				return "/doctor/details";
			}
			else
			{
				return "/doctor/nopatient";
			}
			//System.out.println("in show Doctor login form");
			
		}
		
		
		@GetMapping("/register")
		public String showRegForm(Docter d) {
			//Vendor v=new Vendor(); , invokes getters  , adds this POJO under model map
			//map.addAttibute("vendor",v);
			//System.out.println("in show reg form");
			
			return "/doctor/register";

		}
		
		
		@PostMapping("/register")
		public String processRegForm(@Valid Docter d, BindingResult result,  RedirectAttributes flashMap) {
			
			System.out.println("in process reg form " + d);// transient
			
			if(result.hasErrors())
			{
				System.out.println("P.L errs "+result);
				//in case of P.L errors --forward clnt to reg form
				return "/doctor/register";
			}
			flashMap.addFlashAttribute("mesg", dao.addNewDoctor(d));
			return "redirect:/doctor/login";
		}

	
		@GetMapping("/list")
		public String showDocterList(Model map,HttpSession hs) {
			System.out.println("in show d list");
			//hs.setAttribute("Doctor_list", dao.listDocter());
			return "/doctor/list";
		}
		
		@GetMapping("/dropdown")
		public String doctorspecification(Model map) 
		{
			List<Docter> dl= dao.listDocter();
			map.addAttribute("Doctor_list",dl);
			System.out.println("in show Doctor dropdown form"+dl);
			return "/doctor/dropdown";
		}
		
		@PostMapping("/dropdown")
		public String getappointment(@RequestParam String doc,HttpSession hs) 
		{
			hs.setAttribute("Doctor_list", dao.listDocterBySpecialization(doc));
		//	System.out.println("in show Doctor dropdown form");
			return "redirect:/doctor/list";
		}
		
		

}
