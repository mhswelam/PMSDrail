package com.revature.drail.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAOPLogger {
	
//    private Logger log = Logger.getLogger(getClass());
	  private Logger logger = LoggerFactory.getLogger(this.getClass());		

	@After("execution(* com.revature.drail.service..**.*(..))")
    public void log(JoinPoint point) {
        logger.info(point.getSignature().getName() + " called...");
//		System.out.println("\n ---------------LOGGING------------------");
//    	System.out.println(point.getSignature());
//    	System.out.println("\n \n");
    }
	
}
