package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mappers.UserMapper;
import spring.biz.user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{

	//@Autowired
	@Inject
	private SqlSession sqlsession = null;
	//private UserMapper ui = null;
	
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
		//ui = sqlsession.getMapper(UserMapper.class);
	}

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_MyBatis 연동");
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		return sqlsession.selectOne("user.login", vo);
		//return ui.login(vo);
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlsession.insert("user.add", user);
	}

	@Override
	public UserVO getUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlsession.selectOne("user.getuser", userid);
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlsession.selectList("user.list");
		//return ui.list();
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlsession.update("user.update", user);
	}

	@Override
	public int removeUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlsession.delete("user.remove", userid);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		System.out.println("UserDAO_MyBatis 연동");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		return sqlsession.selectList("user.search", map);
	}
	
}
