package spring.biz.user.service;

import org.springframework.stereotype.Component;

@Component("pleaseImpl")
public class PleaseImpl implements Please{
	public int ppp() {
		System.out.println("please..");
		return 0;
	}
}
