package com.example;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	DBOperations dbo;
	UserDetails uDetails = null;

	public DeleteItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String description = null, type = null, requestedBy = null, status = null, comments = null, category = null, issue = null;
		ServletContext sc = request.getServletContext();
		int idComplaint = (int) sc.getAttribute("comm");
		category = request.getParameter("category");
		issue = request.getParameter("issue");
		String cmethod = request.getParameter("cmethod");
		description = request.getParameter("description");
		requestedBy = request.getParameter("requestedBy");
		comments = request.getParameter("comments");
		status = request.getParameter("status");
		aComplaints.setComplaintid(idComplaint);
		aComplaints.setCategory(category);
		aComplaints.setIssue(issue);
		aComplaints.setDescription(description);
		aComplaints.setCmethod(cmethod);
		aComplaints.setComments(comments);
		aComplaints.setRequestedby((String) session.getAttribute("user"));
		aComplaints.setStatus("Close");

		if (dbo.delete(aComplaints)) {
			session = request.getSession();

			return "Admin.jsp";
		} else {
			session = request.getSession();
			session.setAttribute("operation", "deleted");
			return "error2.jsp";
		}
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		response.sendRedirect(page);

	}

}
