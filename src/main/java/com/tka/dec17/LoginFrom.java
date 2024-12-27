package com.tka.dec17;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/loginFrom")
public class LoginFrom extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email=request.getParameter("email");
	String Password=request.getParameter("Password");
	String submit=request.getParameter("submit");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","Shivani@2003");
		PreparedStatement ps=c.prepareStatement("select*from register where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2,Password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Login Successfully...");
			PrintWriter out=response.getWriter();
			out.print("<h1 style='color:green'>Login Successfully..<h1>");
			
		}else {
			System.out.println("Username and Password didnt match");
			PrintWriter out=response.getWriter();
			out.print("<h1 style='color:red'>Username and Password did'nt Match....</h1>");
			
		}	
		c.close();
	}catch(Exception e){
		
	}
		
	}	

}
