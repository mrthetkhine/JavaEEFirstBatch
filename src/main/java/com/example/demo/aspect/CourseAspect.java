package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CourseAspect {
	
    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* com.example.demo.servie.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
      System.out.println("Advice Before Run ");
    }
    
    @After("execution(* com.example.demo.servie.*.*(..))")
    public void after(JoinPoint joinPoint) {
        //Advice
      System.out.println("Advice After Run ");
    }
    @Around("execution(* com.example.demo.servie.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) {
        //Advice
      System.out.println("Around Before Run ");
      try {
		joinPoint.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("Around After Run ");
    }
}

