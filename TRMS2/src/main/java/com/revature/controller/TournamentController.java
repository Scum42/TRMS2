package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Tournament;
import com.revature.beans.User;
import com.revature.data.TournamentDao;
import com.revature.data.TournamentHibernate;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;
import com.revature.util.HibernateUtilStatic;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class TournamentController {
	private static Logger log = Logger.getLogger(TournamentController.class);
	private static ObjectMapper om = new ObjectMapper();
	private static HibernateUtilStatic hu = HibernateUtilStatic.getInstance();
	private static UserDao uh = new UserHibernate();
	private static TournamentDao td = new TournamentHibernate();

	@RequestMapping(value = "/tournament", method = RequestMethod.GET)
	@ResponseBody
	public String getTournament() throws JsonProcessingException {
		Session session = hu.getSession();
		Tournament t = session.get(Tournament.class, 1);
		String str = om.writeValueAsString(t);
		log.trace(str);
		return om.writeValueAsString(t);
	}
	
	@RequestMapping(value="/tournament-all", method = RequestMethod.GET)
	@ResponseBody
	public String getAllTournaments() throws JsonProcessingException {
		Session session = hu.getSession();
		String query = "From com.revature.beans.Tournament";
		Query<Tournament> q = session.createQuery(query, Tournament.class);
		List<Tournament> tournList = q.getResultList();
		return om.writeValueAsString(tournList);
	}
	
	@RequestMapping(value="/tournament-allOther", method = RequestMethod.GET)
	@ResponseBody
	public String getAllOtherTournaments() throws JsonProcessingException{
		Session session = hu.getSession();
		String query = "From com.revature.beans.Tournament WHERE owner !=:own";
		User owner = uh.getUser(1); 
		//For now, just going to get the tournaments that user 1 doesn't have ... I hope
		Query<Tournament> q = session.createQuery(query, Tournament.class);
		q.setParameter("own", owner);
		List<Tournament> tournList = q.getResultList();
		System.out.println(tournList);
		return om.writeValueAsString(tournList);
	}
	
	// For TESTING on JAVA, setting mapping to GET
	// TODO: Change Get to Post once Angular is working
	@RequestMapping(value="/tournament-join", method = RequestMethod.POST)
	@ResponseBody
	public String joinTourn(@RequestBody Tournament tourn, HttpSession session) throws JsonProcessingException{
		// Assuming we have a tournament passed in ...
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		
		// And assuming that we have a user saved ...
		// Let's get SOMEONE
		// User me = uh.getUser(3);
		User me = (User) session.getAttribute("user");
		log.trace("\n\nUser is: " + me);
		
		if(tourn == null){
			log.trace("tournament was empty");
			return om.writeValueAsString(null);
		}
		else{
			List<User> tourReg = tourn.getRegisteredUsers();
			/*if(tourReg.isEmpty()){
				tourReg = new ArrayList<User>();
				tourReg.add(me);
				tour.setRegisteredUsers(tourReg);
				
				outMess = "RegisteredUsers was empty! Adding ...";
			}else */if(tourReg.contains(me) == false && tourReg.size() + 1 < tourn.getMaxNum()){
				tourReg.add(me);
				tourn.setRegisteredUsers(tourReg);
				log.trace("User wasn't in Registered List! Adding ...");
			}else{
				log.trace("User was already added!");
			}
			Tournament tourUpdated = (Tournament) s.merge(tourn);
			tx.commit();
			log.trace("\n\nUpdated tournament is: " + tourUpdated);
			return om.writeValueAsString(tourUpdated);
		}
	}
}
