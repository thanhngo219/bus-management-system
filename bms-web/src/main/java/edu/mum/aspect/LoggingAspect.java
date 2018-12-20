package edu.mum.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(public * edu.mum.service..save*(..))")
	public void applicationMethod() {
		
	}
	
	@Pointcut("args(object)")
	public void loggingArgs(Object object) {
		
	}
	
	@Before("applicationMethod() && loggingArgs(object)")
	public void doLoggingBeforeSaving(JoinPoint joinPoint, Object object) {
		LOGGER.info("***********BEFORE SAVING************");
		LOGGER.info(joinPoint.getSignature().getDeclaringTypeName());
		LOGGER.info(object.toString());
		LOGGER.info("************************************");
	}
	
	@After("applicationMethod() && loggingArgs(object)")
	public void doLoggingAfterSaving(JoinPoint joinPoint, Object object) {
		LOGGER.info("***********AFTER SAVING************");
		LOGGER.info(joinPoint.getSignature().getDeclaringTypeName());
		LOGGER.info(object.toString());
		LOGGER.info("***********************************");
	}
}
