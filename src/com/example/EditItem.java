package com.example;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	UserDetails uDetails = null;
	DBOperations dbo;

	public EditItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		if ((aComplaints=dbo.getComplaint((String) session.getAttribute("compid")))!=null) {
			ServletContext sc = request.getServletContext();
			sc.setAttribute("comm", aComplaints.getComplaintid());
			session.setAttribute("complaintid", aComplaints.getComplaintid());
			session.setAttribute("category", aComplaints.getCategory());
			session.setAttribute("issue", aComplaints.getIssue());
			session.setAttribute("description", aComplaints.getDescription());
			session.setAttribute("cmethod",aComplaints.getCmethod());
			session.setAttribute("requestedBy", aComplaints.getRequestedby());
			session.setAttribute("status", aComplaints.getStatus());
			session.setAttribute("comments", aComplaints.getComments());

			return "EditRequest.jsp";
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
