package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertItem implements FrontControllerInterface {
	Complaints aComplaints = null;
	DBOperations dbo;
	UserDetails uDetails = null;

	public InsertItem() {
		aComplaints = new Complaints();
		dbo = new DBOperations();
		uDetails = new UserDetails();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String category = null, issue = null, description = null, cmethod = null, requestedBy1=null, status = null, comments = null;
		category = request.getParameter("category");
		issue = request.getParameter("issue");
		description = request.getParameter("description");
		cmethod = request.getParameter("cmethod");
		requestedBy1 = (String) session.getAttribute("user");
		status = request.getParameter("status");
		comments = request.getParameter("comments");
		aComplaints.setCategory(category);
		aComplaints.setIssue(issue);
		aComplaints.setDescription(description);
		aComplaints.setCmethod(cmethod);
		aComplaints.setRequestedby(requestedBy1);
		aComplaints.setStatus(status);
		aComplaints.setComments(comments);
		String test="";

		if (dbo.insertion(aComplaints)) {
			if((test = dbo.displayLatest()) != null){
				session = request.getSession();
				session.setAttribute("operation", "inserted");
				session.setAttribute("result", test);
			}
						
			return "ViewComplaints_1.jsp";
		} else {
			session = request.getSession();
			session.setAttribute("operation", "inserted");
			return "error2.jsp";
		}
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		response.sendRedirect(page);
	}
}
