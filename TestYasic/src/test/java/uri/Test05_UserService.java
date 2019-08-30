package uri;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.service.UserService;
import biz.vo.CheckVO;
import biz.vo.FriendVO;
import biz.vo.MailVO;
import biz.vo.UserVO;
import biz.vo.ViewVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test05_UserService { 
	
	@Autowired
	UserService service;
	
	//@Test
	public void addUser() {
		
	}
	
	//@Test
	public void getUserList() {
		System.out.println(service.getUserList()); 
	} 
	
	//@Test
	public void getFriendList() {
		System.out.println(service.getFriendList("333"));
	} 
	
	//@Test
	public void getCheckContentList() {
		System.out.println(service.getCheckContentList());
	}
	
	//@Test
	public void searchFriends() {
		System.out.println(service.searchFriends("333", "#테"));
	}
	
	//@Test
	public void login() {
		System.out.println(service.login("01066100584", "123"));
	}
	
	//@Test
	public void getUser() {
		System.out.println(service.getUser("01066100584"));
	}
	
	//@Test
	public void updateUser() {
		UserVO user = new UserVO();
		
		System.out.println(service.updateUser(user));
	}
	
	//@Test
	public void getView(){
		System.out.println(service.getView("333"));
	}
	
	//@Test
	public void removeUser(String id) {
		
	}
	//@Test
	public void addFriend() {
		System.out.println(service.addFriend("333", "01066100584"));
	}
	//@Test
	public void removeFriend() {
		System.out.println(service.removeFriend("333", "01066100584"));
	}
	//@Test
	public void getFriendList(String id){
		
	}
	//@Test
	public void addCheckContent(CheckVO content) {
		
	}
	//@Test
	public void removeCheckContent(String id) {
		
	}
	//@Test
	public void updateCheckContent(CheckVO content) {
		
	}
	//@Test
	public void getCheckContent() {
		System.out.println(service.getCheckContent("333"));
	}
	//@Test
	public void searchFriends(String id, String condition){
		
	}
	//@Test
	public void getFriendViewList(){
		System.out.println(service.getFriendViewList("333"));
	}
	//@Test//////////////////////////
	public void sendMail() {
		MailVO mail = new MailVO();
		mail.setId("333");
		mail.setFid("01066100584");
		mail.setWhy("f");
		System.out.println(mail);
		//System.out.println(service.sendMail(mail));
	}
	//@Test
	public void getMail(int num) {
		
	}
	//@Test
	public void friendConfirm(MailVO mail) {
		
	}
	//@Test
	public void meetConfirm(MailVO mail) {
		
	}
	//@Test
	public void cancle(MailVO mail) {
		
	}
	
	
}


