package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserUpdateItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	DBOperations dbo;
	UserDetails uDetails;

	public UserUpdateItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userid = 0;
		String username = null, password = null, firstname = null, lastname = null, position = null, email = null, phone = null, type = null;
		userid = Integer.parseInt(request.getParameter("userid"));
		username = request.getParameter("username");
		password = request.getParameter("password");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		position = request.getParameter("position");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		type = request.getParameter("type");
		uDetails.setUserid(userid);
		uDetails.setUsername(username);
		uDetails.setPassword(password);
		uDetails.setFirstname(firstname);
		uDetails.setLastname(lastname);
		uDetails.setPosition(position);
		uDetails.setEmail(email);
		uDetails.setPhone(phone);
		uDetails.setType(type);
		
		HttpSession session;

		if (dbo.updateuser(uDetails)) {
			session = request.getSession();

			return "UserProfile.jsp";
		} else {
			session = request.getSession();
			session.setAttribute("operation", "updated");
			return "error2.jsp";
		}
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		response.sendRedirect(page);
	}

}
