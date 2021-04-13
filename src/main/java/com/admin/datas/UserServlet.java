package com.admin.datas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

import com.google.appengine.api.datastore.Entity;
/**
 * Class qui peuple le datastore de Petitions (à executer avant petitionServlet)
 *
 */
@SuppressWarnings("serial")
@WebServlet(name = "UserServlet", urlPatterns = { "/populateUsers" })
public class UserServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		Random r = new Random();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		// Create users
		for (int j = 0; j < 1500; j++) {
			Entity e = new Entity("User", "user" + j);
			e.setProperty("firstName", "firstname"+ j);
			e.setProperty("lastName", "lastname"+j);
			datastore.put(e);
		}
		
		response.getWriter().print("AJOUT DE 1500 USERS.\r\n");
	}
}