package com.sp.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopPointCut {

	@Pointcut("execution(* com.sp.contorller.ProductController.hyunjae*(..))")
	public void hyunjae() { }

	 @Before("hyunjae()")
	public void adminBefore(JoinPoint joinPoint) {
	}
}

