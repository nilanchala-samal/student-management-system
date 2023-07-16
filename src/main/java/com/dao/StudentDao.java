package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDao {
	
	private Connection conn;

	public StudentDao(Connection conn) {
		this.conn = conn;
	}
	
	public boolean addStudent(Student student) {
		
		try {
			String sql = "INSERT INTO student(full_name,dob,address,qualification,email) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFullName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			
			int i = ps.executeUpdate();
			if(i==1) return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Student> getAllStudent(){
		List<Student> list = new ArrayList<>();
		Student s = null;
		String sql = "SELECT * FROM student";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				s = new Student();
				s.setId(set.getInt(1));
				s.setFullName(set.getString(2));
				s.setDob(set.getString(3));
				s.setAddress(set.getString(4));
				s.setQualification(set.getString(5));
				s.setEmail(set.getString(6));
				list.add(s); 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Student getStudentById(int id) {
		Student s = null;
		String sql = "SELECT * FROM student WHERE id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				s = new Student();
				s.setId(set.getInt(1));
				s.setFullName(set.getString(2));
				s.setDob(set.getString(3));
				s.setAddress(set.getString(4));
				s.setQualification(set.getString(5));
				s.setEmail(set.getString(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public boolean updateStudent(Student student) {
		String sql = "UPDATE student set full_name=?,dob=?,address=?,qualification=?,email=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFullName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			ps.setInt(6, student.getId());
			
			int res = ps.executeUpdate();
			if(res==1) return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteStudent(int id) {
		String sql = "DELETE FROM student WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int res = ps.executeUpdate();
			if(res==1) return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
