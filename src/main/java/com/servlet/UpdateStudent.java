package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

@WebServlet("/update")
public class UpdateStudent extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		Student s = new Student(id,name,dob,address,qualification,email);
		
		StudentDao dao = new StudentDao(DBConnect.getConnection());
		HttpSession session = req.getSession();
		
		boolean flag = dao.updateStudent(s);
		
		if(flag) {
			session.setAttribute("succMsg", "Student details updated successfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg", "Something went wrong on server");
			resp.sendRedirect("index.jsp");
		}
		
	}

}
