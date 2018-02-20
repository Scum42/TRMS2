package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Results;
import com.revature.data.ResultsDao;
import com.revature.util.JsonUtil;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class ResultsController {

	@Autowired
	ResultsDao rd;
	
	@Autowired
	JsonUtil ju;
	
	private static Logger log = Logger.getLogger(ResultsController.class);
	
	@RequestMapping(value = "/results", method = RequestMethod.POST)
	@ResponseBody
	public String submitResults(@RequestBody Results r, HttpSession httpSession) {
		try {
			log.trace(r);
			rd.persistResults(r);
			return ju.toJson(r);
		} catch (Exception e) {
			return JsonUtil.JSON_NULL;
		}
	}
}
