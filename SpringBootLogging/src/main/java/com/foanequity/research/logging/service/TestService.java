package com.foanequity.research.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	private Logger logger = LoggerFactory.getLogger(TestService.class);

	public void service() {
		logger.info("Message at INFO level from TestService.service()");
		logger.warn("Message at WARN level from TestService.service()");
	}
}
