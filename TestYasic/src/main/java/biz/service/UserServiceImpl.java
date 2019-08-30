package biz.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import biz.dao.DAO;
import biz.vo.CheckVO;
import biz.vo.FriendVO;
import biz.vo.MailVO;
import biz.vo.UserVO;
import biz.vo.ViewVO;


//@Component("service")
@Service("service")
public class UserServiceImpl implements UserService{
	
	@Resource(name="mybatis")
	private DAO dao;
	
	@Autowired
	private ApplicationContext context;

	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	@Override
	public UserVO login(String id, String pw) {
		return dao.login(id, pw);
	}

	@Override
	public UserVO getUser(String id) {
		return dao.getUser(id); 
	}

	@Override
	public int removeUser(String id) {
		return dao.removeUser(id);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int addFriend(String id, String fid) {
		return dao.addFriend(id, fid);
	}

	@Override
	public int removeFriend(String id, String fid) {
		return dao.removeFriend(id, fid);
	}

	@Override
	public List<FriendVO> getFriendList(String id) {
		return dao.getFriendList(id);
	}

	@Override
	public int addCheckContent(CheckVO content) {
		return dao.addCheckContent(content);
	}

	@Override
	public int removeCheckContent(String id) {
		return dao.removeCheckContent(id);
	}

	@Override
	public int updateCheckContent(CheckVO content) {
		return dao.updateCheckContent(content);
	}

	@Override
	public CheckVO getCheckContent(String id) {
		return dao.getCheckContent(id);
	}

	@Override
	public List<ViewVO> searchFriends(String id, String condition) {
		return dao.searchFriends(id, condition);
	}

	@Override
	public int sendMail(MailVO mail) {
		return dao.sendMail(mail);
	}

	@Override
	public MailVO getMail(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int friendConfirm(MailVO mail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int meetConfirm(MailVO mail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancle(MailVO mail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CheckVO> getCheckContentList() {
		return dao.getCheckContentList();
	}

	@Override
	public List<ViewVO> getFriendViewList(String id) {
		return dao.getFriendViewList(id);
	}

	@Override
	public ViewVO getView(String id) {
		return dao.getView(id);
	}
	
	@Override
	public UserVO getUserImg(String id) {
		return dao.getUserImg(id); 
	}

}
