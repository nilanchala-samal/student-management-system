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

@WebServlet("/delete")
public class DeleteStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int  id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao(DBConnect.getConnection());
		boolean flag = dao.deleteStudent(id);
		
		HttpSession session = req.getSession();
		
		if(flag) {
			session.setAttribute("succMsg", "Student data deleted successfully");
			resp.sendRedirect("index.jsp"); 
		}else {
			session.setAttribute("errorMsg", "Something went wrong on server");
			resp.sendRedirect("index.jsp");
		}
	}

}
