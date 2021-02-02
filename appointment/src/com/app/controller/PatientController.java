package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.app.pojos.Appointment;
import com.app.pojos.Docter;
import com.app.pojos.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController 
{
	@Autowired // auto wiring by type
	private IPatientDao dao;

	@Autowired // auto wiring by type
	private IDoctorDao dao1;

	public PatientController()
	{
		//System.out.println("in Patient controller constr");
	}

	// request handling method to show login form
		@GetMapping("/login")
		public String showLoginForm() 
		{
			//System.out.println("in show patient login form");
			return "/patient/login";
		}

	// request handling method to process login form	
		@PostMapping("/login")
		public String processLoginForm(@RequestParam String em,
				@RequestParam String pass, Model map,
				RedirectAttributes flashMap, HttpSession hs)
		{
			//System.out.println("in patient login form");
			// invoke dao's method for auth.
			try 
			{
				Patient P = dao.auntheticatepatient(em, pass);
				// valid login
				hs.setAttribute("patient_dtls", P);
				//System.out.println(P);// till logout
				flashMap.addFlashAttribute("mesg", "Login Successful");// till next request
				return "/patient/home";
				
			} 
			catch (RuntimeException e)
			{
				System.out.println("error in controller " + e);
				map.addAttribute("mesg", "Invalid Login");
				// invalid login
				return "/patient/login";
			}

		}
		@GetMapping("/details")
		public String welcome() 
		{
			
			
			//System.out.println("in show Patient login form");
			return "/patient/details";
		}
		

		@GetMapping("/register")
		public String showRegForm(Patient p) {
			
			//System.out.println("in show reg form");
			
			return "/patient/register";

		}
		
		
		@PostMapping("/register")
		public String processRegForm(@Valid Patient p, BindingResult result,  RedirectAttributes flashMap) {
			
			System.out.println("in process reg form " + p);// transient
			//chk for p.l errors
			if(result.hasErrors())
			{
				System.out.println("P.L errs "+result);
				//in case of P.L errors --forward clnt to reg form
				return "/patient/register";
			}
			flashMap.addFlashAttribute("mesg", dao.addNewPatient(p));
			return "redirect:/patient/login";
		}
		
		/*@GetMapping("/list")
		public String showPatientList(Model map) {
			System.out.println("in show P list");
			map.addAttribute("Patient_list", dao.listPatient());
			return "/patient/list";
		}*/
		
		@GetMapping("/list")
		public String showDocterList(Model map) {
			//System.out.println("in show d list");
			map.addAttribute("Doctor_list", dao.GetAllDocter());
			return "redirect:/doctor/list";
		}
	
		
		@GetMapping("/appointment")
		public String getpage(@RequestParam int Did,HttpSession hs)
		{
			hs.setAttribute("Did", Did);
			return "/patient/appointment";
		}
		
		
		@PostMapping("/appointment")
		public String getpage(@RequestParam String date,@RequestParam String time, RedirectAttributes flashMap,HttpSession hs,Model map)
		{
			int d=(int)hs.getAttribute("Did");
			
			Patient p=(Patient)hs.getAttribute("patient_dtls");
			//System.out.println(a);
			Appointment a=new Appointment();
			a.setDate(date);
			a.setTime(time);
		
			Docter d1=dao1.getdocterbyid(d);
			
			a.setDoc(d1);
			flashMap.addFlashAttribute("mesg", dao.addappointment(a));
			Appointment a1= dao.getApootintmnetByDid(d);
			dao.updateDId(d1,a1, p);
			//return "/patient/appointment";
			map.addAttribute("Apt_details",a1);
			
		
			return "/patient/docspecialization";
		}
		
		@GetMapping("/logout")
		public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
			System.out.println("in patient logout");
			//copy session attr ---> model map
			map.addAttribute("patient_dtls",hs.getAttribute("patient_dtls"));
			//set refresh hdr
			resp.setHeader("refresh", "5;url="+request.getContextPath());
			//discard session
			hs.invalidate();
			return "/patient/logout";
		}
		
		@GetMapping("/delete")
		public String deleteVendor(@RequestParam int aid, RedirectAttributes flashMap) {
			System.out.println("in appintment details " + aid);
			flashMap.addFlashAttribute("mesg", dao.deleteappointment(aid));
			// redirect clnt to vendor list page
			return "redirect:/doctor/list";
		}

}
