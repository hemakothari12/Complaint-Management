package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserDisplayItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	DBOperations dbo;
	String res;
	UserDetails uDetails = null;

	public UserDisplayItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if ((res = dbo.displayuser()) != null) {
			request.setAttribute("operation", "display");
			request.setAttribute("result", res);

			return "displayallusers.jsp";
		} else
			return "error2.jsp";
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
