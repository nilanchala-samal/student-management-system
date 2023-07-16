package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	
	private int id;
	private String fullName;
	private String dob;
	private String address;
	private String qualification;
	private String email;
	
	public Student(String fullName, String dob, String address, String qualification, String email) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.qualification = qualification;
		this.email = email;
	}
	
	

}
