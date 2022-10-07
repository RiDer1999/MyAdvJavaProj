package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h3 style='text-align:center'>Employee List</h3>");

		try {
			List<emp> list = EmpDao.getAllEmployee();
			out.println("<table width=80% align=center border=1>");
			out.println("<th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th><th colspan=2>Operation</th></tr>");
			
			for (emp e : list) {

				out.println("<tr><td>" + e.getId() + "</td><td>" + e.getUname() + "</td><td>" + e.getEmail()
						+ "</td><td>" + e.getPASSWORD() + "</td><td>" + e.getCountry() + "</td>"
						+ "<td><a href='editServlet?id=" + e.getId() + "'>edit</a></td>"
						+ "<td><a href='deleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");

			}
			out.println("</table>");

			out.println("<h3 style='text-align:center;color:green'><a href='crud.html'>Add New Employee</a></h3>");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
