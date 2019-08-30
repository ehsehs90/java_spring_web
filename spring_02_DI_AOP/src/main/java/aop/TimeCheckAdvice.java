package aop;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("advice")
@Aspect
public class TimeCheckAdvice {
	@Pointcut("execution(* spring.biz.user.service.UserService.*(..))")
	public void pointcut() {}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("---------start----------");
		Object obj = pp.proceed();
		System.out.println("---------end----------");
		long end = System.currentTimeMillis();
		System.out.println(pp.toShortString() + "->" + (end-start) + "millisecond");
		return obj;
	}
}
