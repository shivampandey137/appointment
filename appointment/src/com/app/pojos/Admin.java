package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="Admin")
public class Admin 
{
	private Integer adminId;
	@NotEmpty(message = "Enter Valid UserName")
	private String UserName;
	@NotEmpty(message = "Enter Valid Password")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,10})")
	private String Password;
	
	public Admin()
	{
		super();
	}

	public Admin(String userName, String password) 
	{
		super();
		UserName = userName;
		Password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(length = 20)
	public String getUserName() 
	{
		return UserName;
	}

	public void setUserName(String userName) 
	{
		UserName = userName;
	}

	@Column(length = 20, nullable = false)
	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String password) 
	{
		Password = password;
	}

	@Override
	public String toString() 
	{
		return "Admin [UserName=" + UserName + ", Password=" + Password + "]";
	}
	
	
	
}
