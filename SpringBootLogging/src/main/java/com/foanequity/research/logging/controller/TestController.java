package com.foanequity.research.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foanequity.research.logging.model.TestModel;
import com.foanequity.research.logging.service.TestService;

@RestController
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestModel model;

	@Autowired
	private TestService service;

	@GetMapping("/hello/{name}")
	public @ResponseBody String hello(@PathVariable("name") String name) {

		logger.error("Message logged at ERROR level");
		logger.warn("Message logged at WARN level");
		logger.info("Message logged at INFO level");
		logger.debug("Message logged at DEBUG level");

		return String.format("Hello %s", name);
	}

}
