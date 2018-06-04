package com.foanequity.research.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.foanequity.research.logging.model.TestModel;
import com.foanequity.research.logging.service.TestService;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		logger.error("Message logged at ERROR level");
		logger.warn("Message logged at WARN level");
		logger.info("Message logged at INFO level");
		logger.debug("Message logged at DEBUG level");

		TestModel model = new TestModel();
		TestService service = new TestService();
		service.service();
	}
}
