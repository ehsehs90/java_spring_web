package spring.biz.user.service;

import java.util.List;

import spring.biz.user.vo.UserVO;

public interface UserService {
	UserVO login(String id, String pw);
	int addUser(UserVO user);
	UserVO getUser(String uid);
	List<UserVO> getUserList();
	int updateUser(UserVO user);
	int removeUser(String uid);
	List<UserVO> searchUser(String condition, String keyword);
}
