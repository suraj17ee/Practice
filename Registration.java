package com.loginexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Registration extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String user = req.getParameter("user");
		String mobile = req.getParameter("mobile");
		String pass = req.getParameter("pass");
		Connection cn = null;
		PreparedStatement pst = null;
		PrintWriter ab = resp.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "abcd");
			pst = cn.prepareStatement("insert into loginpageex.reg values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, mobile);
			pst.setString(3, user);
			pst.setString(4, pass);
			pst.executeUpdate();

			ab.println("<html>" + "<body>" + "<h1>Registration Successfull!!</h1>"
					+ "<a href='LogIn.html'>Click here to login</a>" + "</body>" + "</html>");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
