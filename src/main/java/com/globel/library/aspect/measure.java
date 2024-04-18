package com.globel.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Order(1)
@Component
public class measure {


	@Pointcut(value = "execution(* com.globel.library.repository.*.*(..))" )
	public void forRepositoryLog () {}
	
	@Pointcut(value = "execution(* com.globel.library.service.*.*(..))" )
	public void forServiceLog () {}
	
	@Pointcut(value = "execution(* com.globel.library.controller.*.*(..))" )
	public void forControllerLog () {}
	
	@Pointcut(value = "forRepositoryLog() || forServiceLog() || forControllerLog()" )
	public void forAllApp () {}
	
	
	@Before(value = "forAllApp()")
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methidName = joinPoint.getSignature().toShortString();
		
		log.info("======> method name is >> " , methidName);
		
		Object [] args = joinPoint.getArgs();
		
		for(Object arg:args) {
			log.info("===> argument >> {}" , arg);
		}
		
		
	}
}
