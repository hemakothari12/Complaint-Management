package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FrontControllerInterface {
	public String execute( // change the database
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public void dispatch(HttpServletRequest request, // find from database and display jsp
			HttpServletResponse response, String page) throws Exception;
}
