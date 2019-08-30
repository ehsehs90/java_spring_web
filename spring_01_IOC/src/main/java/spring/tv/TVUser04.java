package spring.tv;

import java.util.Calendar;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TVUser04 {

	public static void main(String[] args) {
		String[] config = { "applicationContext.xml" };

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

		TV user = (TV) applicationContext.getBean("lg");
		user.on();
		TV user2 = applicationContext.getBean("lg", TV.class);
		user2.on();

		//System.out.println(user == user2);

		Calendar cal = (Calendar) applicationContext.getBean("now");
	}

}
