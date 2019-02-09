package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	UserDetails uDetails = null;
	DBOperations dbo;
	String res;

	public DisplayItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if ((res = dbo.display()) != null) {
			request.setAttribute("operation", "display");
			request.setAttribute("result", res);

			return "ViewComplaints.jsp";
		} else
			return "error2.jsp";
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
