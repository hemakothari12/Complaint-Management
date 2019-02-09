package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class ComplaintController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Initializes the servlet.
	FrontControllerInterface mycommand;
	Session mysession = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String page = null;
		HttpSession session = request.getSession();
		try {
			System.out.println(request.getParameter("action"));
			if (request.getParameter("action").equals("login")) {
				mycommand = (FrontControllerInterface) new LoginItem();
			} else if (request.getParameter("action").equals("insert")){
				mycommand = (FrontControllerInterface) new InsertItem();	
			} else if (request.getParameter("action").equals("update")){
				mycommand = (FrontControllerInterface) new UpdateItem();	
			} else if (request.getParameter("action").equals("close")) {
				String s = request.getParameter("item");
				session.setAttribute("compid", s);
				mycommand = (FrontControllerInterface) new CloseItem();
			} else if (request.getParameter("action").equals("edit")) {
				String s = request.getParameter("item");
				session.setAttribute("compid", s);
				mycommand = (FrontControllerInterface) new EditItem();
			} else if (request.getParameter("action").equals("delete")) {
				String s = request.getParameter("item");
				session.setAttribute("compid", s);
				mycommand = (FrontControllerInterface) new DeleteItem();
			} else if (request.getParameter("action").equals("display")) {
				mycommand = (FrontControllerInterface) new DisplayItem();
			} else if (request.getParameter("action").equals("userinsert")) {
				mycommand = (FrontControllerInterface) new UserInsertItem();
			} else if (request.getParameter("action").equals("userfind")) {
				mycommand = (FrontControllerInterface) new UserFindItem();
			} else if (request.getParameter("action").equals("userupdate")) {
				mycommand = (FrontControllerInterface) new UserUpdateItem();
			}else if (request.getParameter("action").equals("userdelete")) {
				mycommand = (FrontControllerInterface) new UserDeleteItem();
			}else if (request.getParameter("action").equals("userdisplay")) {
				mycommand = (FrontControllerInterface) new UserDisplayItem();
			} else if (request.getParameter("action").equals("search")) {
				mycommand = (FrontControllerInterface) new SearchItem();
			}
			page = mycommand.execute(request, response);
			mycommand.dispatch(request, response, page);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<HTML><b>Check Enter Details (Missing input)</b></HTML>");
			RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
			rd.include(request, response);
		}
	}
}
