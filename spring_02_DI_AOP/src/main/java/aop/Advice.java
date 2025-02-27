package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import spring.biz.user.vo.UserVO;

public class Advice {
	public void log(JoinPoint jp) {
		System.out.println("***** Log Start ******");
		System.out.println(jp.toString());
//		for(Object o:jp.getArgs())
//			System.out.println(o);
		//System.out.println(jp.getArgs()[0]);
		//System.out.println(e);
		System.out.println("***** Log End ********");
	}
	
	public void after_Return(Object data) {
		System.out.println("********after_Return********");
		System.out.println(data);
		System.out.println("********after_Return********");
	}
	
	public Object around(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("********around********");
		Object obj = pp.proceed();
		UserVO vo = null;
		if(obj != null && obj instanceof UserVO) {
			vo = (UserVO) obj;
			vo.setUserpwd("******");
		}
		System.out.println("********around********");
		return obj;
	}
}
