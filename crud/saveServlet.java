package com.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id1"));
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		
		emp e1 = new emp();
		e1.setId(id);
		e1.setUname(uname);
		e1.setEmail(email);
		e1.setPASSWORD(password);
		e1.setCountry(country);
		int status=0;
		
		status = EmpDao.save(e1);
		if(status>0)
		{
			 out.println("<h3 style='color:green;text-align:center'>Record Successfully inserted</h3>");
			 request.getRequestDispatcher("crud.html").include(request,response);
		}
		else
		{
			out.println("<h3 style='color:red;text-align:center'>Sorry ! Unable to insert record try again</h3>");
			 request.getRequestDispatcher("crud.html").include(request,response);
		}
		
		
		
		
		
		
		
	}

}
