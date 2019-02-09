package com.example;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	UserDetails uDetails = null;
	DBOperations dbo;

	public LoginItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String username = null;
		String password = null;
		username = request.getParameter("username");
		password = request.getParameter("password");
		session.setAttribute("user", username);
		uDetails.setUsername(username);		
		uDetails.setPassword(password);

		if ((uDetails = dbo.login(username, password)) != null) {
			if(uDetails.getUsername() != null && uDetails.getPassword() != null ){
				request.setAttribute("username", uDetails.getUsername());
				request.setAttribute("password", uDetails.getPassword());
				request.setAttribute("type", uDetails.getType());
				session.setAttribute("usertype", uDetails.getType());
				session.setAttribute("firstname", uDetails.getFirstname());
				session.setAttribute("lastname", uDetails.getLastname());
				session.setAttribute("position", uDetails.getPosition());
				session.setAttribute("email", uDetails.getEmail());
				session.setAttribute("phone", uDetails.getPhone());
				
				if(uDetails.getType().equals("admin"))
					return "Admin.jsp";
				else
					return "User.jsp";
			} else {
				return "Login.jsp";
			}
		} else
			return "error2.jsp";
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
