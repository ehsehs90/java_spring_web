package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test03_UserService {
	
	@Autowired
	UserService service;
	
	//@Before
	public void setUpBeforeClass() throws Exception {
		UserDAO dao = new UserDAO_JDBC();
		service = new UserServiceImpl(dao); 
	}

	//@Test
	public void login() {
		System.out.println(service.login("admin", "a1234"));
	}
	
	@Test
	public void list() {
		for(UserVO vo:service.getUserList()) {
			System.out.println(vo);
		}
	}
	
	//@Test
	public void add() {
		UserVO user = new UserVO(
				"hail",
				"강하일",
				"1332",
				"ehfkwlrnd@naver.com",
				"6610-0584",
				"경기도 안양");
		System.out.println(service.addUser(user));
	}
	//@Test
	public void update() {
		UserVO user = service.getUser("hail");
		user.setPhone("010-6610-0584");
		int row = service.updateUser(user);
		System.out.println(row);
	}
	//@Test
	public void getUser() {
		System.out.println(service.getUser("admin"));
	}
	//@Test
	public void removeUser() {
		int row = service.removeUser("hail");
		System.out.println(row);
	}
	//@Test
	public void searchUser() {
		for(UserVO vo:service.searchUser("username", "강")) {
			System.out.println(vo);
		}
	}

}
