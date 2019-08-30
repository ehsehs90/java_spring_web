package spring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.dao.UserDAO_Spring;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class Test02_UserService {

	UserDAO dao = new UserDAO_JDBC();
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO_JDBC();
		UserService service = new UserServiceImpl(dao); 
		System.out.println(service.login("admin", "1234"));
		System.out.println(service.login("admin", "a1234"));
		
		for(UserVO vo:service.getUserList()) {
			System.out.println(vo);
		}
	}
}
