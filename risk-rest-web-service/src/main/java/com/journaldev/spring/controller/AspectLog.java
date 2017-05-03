package com.journaldev.spring.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
public class AspectLog {

	public static final Logger logger = LoggerFactory.getLogger("generic");

	@Before("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..)) && target(controller) ")
	public void logControllerAccess(JoinPoint jp, Object controller)
			throws Throwable {
		logger.info("Executing  request->" + jp.toString() + "<-");

		logger.info("Executing  request->" + jp.getSignature().getName() + "<-");

		logger.info("Executing  request->" + jp.ADVICE_EXECUTION + "<-");

		logger.info("Executing  request->"
				+ controller.getClass().getCanonicalName() + "<-");

		logger.debug("Executing {} debug  request");
		logger.info("Executing {} info request");

	}

	@Before("execution(* com.journaldev.spring.controller.DrugController.*(..))")
	public void getAllAdviceA() {
		logger.info("###################################  AFTER getAllAdviceA Service method getter called  GIMI ###########################");

	}

}
