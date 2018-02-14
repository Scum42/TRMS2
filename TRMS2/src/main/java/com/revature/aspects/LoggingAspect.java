package com.revature.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LoggingAspect {

	private Logger log = Logger.getRootLogger();

	/* Hooks */
	@Pointcut("execution(* com.revature..*(..))")
	public void allMethods() {
		/* Hook for all methods in the entire project */
	}

	/* Aspects */
	@Around("allMethods()")
	public Object log(ProceedingJoinPoint pjp) {
		log.trace("Method `" + pjp.getSignature() + "` invoked with arguments " + Arrays.toString(pjp.getArgs()));
		Object pjpReturn = null;

		try {
			pjpReturn = pjp.proceed();
		} catch (Throwable e) {
			log.error(e);

			for (StackTraceElement s : e.getStackTrace()) {
				log.warn(s);
			}
		}

		log.info("Method `" + pjp.getSignature() + "` returned " + pjpReturn);
		return pjpReturn;
	}

}
