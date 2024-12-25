package com.tka.dec17;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterFrom extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName =request.getParameter("First Name");
		String FatherName=request.getParameter("Father name");
		String LastName=request.getParameter("Last Name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String Dob=request.getParameter("dob");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String age=request.getParameter("age");
		String degree=request.getParameter("degree");
		String passingYear=request.getParameter("PassingYear");
		String password=request.getParameter("Password");
		String submit=request.getParameter("submit");
		String reset=request.getParameter("reset");
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","Shivani@2003");
			PreparedStatement ps = c.prepareStatement("INSERT INTO  register(name, fatherName, lastName, email, mobile, address, gender, dob, city, state, country, age, degree, passingYear, password)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,FirstName );
			ps.setString(2,FatherName );
			ps.setString(3,LastName );
			ps.setString(4, email);
			ps.setString(5,mobile );
			ps.setString(6,address);
			ps.setString(7,gender );
			ps.setString(8,Dob );
			ps.setString(9,city );
			ps.setString(10,state );
			ps.setString(11,country);
			ps.setString(12,age );
			ps.setString(13,degree );
			ps.setString(14,passingYear );
			ps.setString(15,password);
			ps.executeUpdate();
			System.out.println("Data is Inserted Scussfully..");
			c.close();
		}catch(Exception e) {
		
		}
		PrintWriter out=response.getWriter();
		out.println("Data is Inserted Scussfully...");
	}
}




