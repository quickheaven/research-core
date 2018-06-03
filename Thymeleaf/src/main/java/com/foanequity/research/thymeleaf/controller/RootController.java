package com.foanequity.research.thymeleaf.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class RootController {

	private static final Logger logger = LoggerFactory.getLogger(RootController.class);

	private static final String EMAIL_SIMPLE_TEMPLATE_NAME = "html/Template";

	@Autowired
	private ITemplateEngine thymeleafTemplateEngine;

	@GetMapping("/template")
	public @ResponseBody String getGeneratedTemplate() {
		// Prepare the evaluation context
		final Context ctx = new Context(Locale.US);
		ctx.setVariable("name", "John Doe");
		ctx.setVariable("subscriptionDate", new Date());
		ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

		/* begin handling of map. */
		Map<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);		
		map.put("user.id", "10");
		map.put("User.name", "foo");
		ctx.setVariable("map", map);		
		/* end handling of map */
		
		final String processHtml = this.thymeleafTemplateEngine.process(EMAIL_SIMPLE_TEMPLATE_NAME, ctx);

		logger.info("{}", processHtml);

		return processHtml;
	}

}
