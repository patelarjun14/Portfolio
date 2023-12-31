package app.servlet;

import app.dal.*;
import app.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * FindUsers is the primary entry point into the application.
 * 
 * Note the logic for doGet() and doPost() are almost identical. However, there is a difference:
 * doGet() handles the http GET request. This method is called when you put in the /findusers
 * URL in the browser.
 * doPost() handles the http POST request. This method is called after you click the submit button.
 * 
 * To run:
 * 1. Run the SQL script to recreate your database schema: http://goo.gl/86a11H.
 * 2. Insert test data. You can do this by running blog.tools.Inserter (right click,
 *    Run As > JavaApplication.
 *    Notice that this is similar to Runner.java in our JDBC example.
 * 3. Run the Tomcat server at localhost.
 * 4. Point your browser to http://localhost:8080/BlogApplication/findusers.
 */
@WebServlet("/displaytrails")
public class DisplayTrails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected TrailsDao trailsDao;
	
	@Override
	public void init() throws ServletException {
		trailsDao = TrailsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        Map<String, String[]> trailsData = new HashMap<String, String[]>();
        req.setAttribute("trailsData", trailsData);
        String[] ids = new String[30];
        String[] names= new String[30];
        String[] description = new String[30];
        
        List<Trails> trails = new ArrayList<Trails>();

        String difficulty = req.getParameter("difficulty");
        if (difficulty == null || difficulty.trim().isEmpty()) {
        	// Retrieve Trails, and store as a message.
        	try {
            	trails = trailsDao.allTrailsByName();
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }
    	else {    	
        	// Retrieve Trails, and store as a message.
        	try {
            	trails = trailsDao.getTrailsFromDifficulty(difficulty);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
    	}	
        	
    	for (int i = 0; i < trails.size(); i++) {
    		messages.put(trails.get(i).getTrailName(), trails.get(i).getDescription());
    		ids[i] = Integer.toString(trails.get(i).getTrailId());
    		names[i] = trails.get(i).getTrailName();
    		description[i] = trails.get(i).getDescription();
    	}
    	trailsData.put("ids", ids);
    	trailsData.put("names", names);
    	trailsData.put("description", description);
        req.getRequestDispatcher("/DisplayTrails.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Trails> trails = new ArrayList<Trails>();

        String difficulty = req.getParameter("difficulty");
        if (difficulty == null || difficulty.trim().isEmpty()) {
        	// Retrieve Trails, and store as a message.
        	try {
            	trails = trailsDao.allTrailsByName();
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }
    	else {    	
        	// Retrieve Trails, and store as a message.
        	try {
            	trails = trailsDao.getTrailsFromDifficulty(difficulty);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
    	}	
        	
    	for (int i = 0; i < trails.size(); i++) {
    		messages.put("Description", trails.get(i).getDescription());
    	}
        req.getRequestDispatcher("/DisplayTrails.jsp").forward(req, resp);
     
	}    
}
	


