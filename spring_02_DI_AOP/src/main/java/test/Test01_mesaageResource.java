package test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.service.Please;
import spring.biz.user.service.PleaseImpl;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

public class Test01_mesaageResource {
	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		//System.out.println(context.getMessage("hello", null, Locale.ENGLISH));
		
		//String msg = context.getMessage("login.fail", new Object[] {"java01"}, Locale.KOREA);
		//System.out.println(msg);
//		UserService service = (UserService) context.getBean("userservice");
//		UserVO vo = service.login("admin", "a1234");
		Please p =  (Please) context.getBean("pleaseImpl");
		p.ppp();
		//service.getUserList();
		//System.out.println("==========");
		//System.out.println(vo);
		//System.out.println("==========");
	}
}
