package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	DBOperations dbo;
	UserDetails uDetails = null;

	public SearchItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int searchcomplaint;
		searchcomplaint = Integer.parseInt(request.getParameter("searchcomplaint"));
		HttpSession session = request.getSession();

		if ((aComplaints = dbo.getComplaint(request.getParameter("searchcomplaint"))) != null) {
			ServletContext sc = request.getServletContext();
			sc.setAttribute("comm", aComplaints.getComplaintid());
			session.setAttribute("complaintid", aComplaints.getComplaintid());
			session.setAttribute("category", aComplaints.getCategory());
			session.setAttribute("issue", aComplaints.getIssue());
			session.setAttribute("description", aComplaints.getDescription());
			session.setAttribute("cmethod", aComplaints.getCmethod());
			session.setAttribute("requestedBy", aComplaints.getRequestedby());
			session.setAttribute("status", aComplaints.getStatus());
			session.setAttribute("comments", aComplaints.getComments());

			return "EditRequest.jsp";
		} else
			return "SearchComplaint.jsp";
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
