package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFindItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	DBOperations dbo;
	UserDetails uDetails = null;

	public UserFindItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userid;
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

		if ((uDetails = dbo.userfind(userid)) != null) {
			request.setAttribute("userid", String.valueOf(uDetails.getUserid()));
			request.setAttribute("username", uDetails.getUsername());
			request.setAttribute("password", uDetails.getPassword());
			request.setAttribute("firstname", uDetails.getFirstname());
			request.setAttribute("lastname", uDetails.getLastname());
			request.setAttribute("position", uDetails.getPosition());
			request.setAttribute("email", uDetails.getEmail());
			request.setAttribute("phone", uDetails.getPhone());
			request.setAttribute("type", uDetails.getType());

			return "UserProfile.jsp";
		} else
			return "error2.jsp";
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
