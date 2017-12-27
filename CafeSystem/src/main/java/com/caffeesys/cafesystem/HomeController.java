package com.caffeesys.cafesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String me() {
		logger.info("self-introduction page");
		return "/home/homeMyInfo";
	}
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project() {
		logger.info("project introduction page");
		return "/home/homeProject";
	}
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team() {
		logger.info("team introduction page");
		return "/home/homeTeam";
	}
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String projectStart() {
		logger.info("project start page");
		return "/home/projectStart";
	}
}