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
 * Class qui peuple le datastore de Petitions (à executer après userServlet)
 *
 */
@SuppressWarnings("serial")
@WebServlet(name = "PetServlet", urlPatterns = { "/populatePetitions" })
public class PetitionServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		Random r = new Random();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		//Create petitions
		for (int i = 0; i < 500; i++) {
			Entity entity = new Entity("Petition", "petition" + i);
			int owner = r.nextInt(1500);
			entity.setProperty("owner","user"+owner);
			entity.setProperty("Date",new Date());
			entity.setProperty("Description","Description of the petition.");
			
			//Create random voters
			ArrayList<String> voters = new ArrayList<String>();
			for (int j = 0; j < (300+r.nextInt(900)); j++) {
				voters.add("user"+r.nextInt(1500));
			}
			entity.setProperty("voters", voters);
			entity.setProperty("nbvoters", voters.size());
			
			//Create random tags
			ArrayList<String> tags = new ArrayList<String>();
			while (tags.size()<10) {
				tags.add("tag"+r.nextInt(50));
			}
			entity.setProperty("tags", tags);
			datastore.put(entity);
		}
		response.getWriter().print("AJOUT DE 500 PETITIONS.\r\n");
		response.getWriter().print("--> AVEC AU MOINS 300 VOTANTS.\r\n");
		response.getWriter().print("--> ET 10 TAGS.\r\n");
	}
}