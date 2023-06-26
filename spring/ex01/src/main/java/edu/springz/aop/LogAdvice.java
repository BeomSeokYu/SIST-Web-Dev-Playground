package edu.springz.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	// AspectJ 표현식
	// execution([접근제한자] 반환 타입 [패키지.클래스.]이름([매개변수|...]) [throws 예외] )
	
	@Around("execution(* edu.springz.service.SampleService*.*(..))")
	public Object logAround(ProceedingJoinPoint pjp) {
		log.info("ProceedingJoinPoint : " + pjp);
		
		Object result = null;
		log.info("TARGET : " + pjp.getTarget());
		log.info("PARAM : " + Arrays.toString(pjp.getArgs()));
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("result : " + result);
		return result;
	}
	
	@AfterThrowing(	pointcut = "execution(* edu.springz.service.SampleService*.*(..))",
					throwing = "exception")
	public void logException(Exception exception) {
		log.info("exception!");
		log.info("exception : " + exception);
	}
	
	@Before("execution(* edu.springz.service.SampleService*.doAdd(String, String)) && args(s1, s2)")
	public void logBeforeWithParam(String s1, String s2) {
		log.info("s1 : " + s1);
		log.info("s2 : " + s2);
	}
	
	@Before("execution(* edu.springz.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("logBefore()................");
	}
}
