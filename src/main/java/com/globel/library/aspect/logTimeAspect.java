package com.globel.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Order(0)
@Component
public class logTimeAspect {

	
	// logTime for each request to know runtime 
	
	@Around(value = "execution(* com.globel.library.service.*.*(..))" )
	public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
		Long stratTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder("KPI : ");
		sb.append("[").append(joinPoint.getKind()).append("]\for:").append(joinPoint.getSignature())
		.append("\twithArgs: ").append("(").append(joinPoint.getArgs()).append(")");
		sb.append("\ttook: ");
		Object returnValue = joinPoint.proceed();
		log.info(sb.append(System.currentTimeMillis() - stratTime).append(" ms.").toString());
		
		return returnValue ;
	}
	
	
}
