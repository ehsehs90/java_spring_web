package mappers;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.test.context.jdbc.Sql;

import biz.vo.FriendVO;
import biz.vo.MailVO;
import biz.vo.CheckVO;
import biz.vo.UserVO;
import biz.vo.ViewVO;

public interface UserMapper {
		
	    @Insert("insert into userlist(id, pw, name, sex, age, img) values(#{id}, #{pw}, #{name}, #{sex}, #{age}, #{img})")
	    int addUser(UserVO user);
	    
	    @Update("update userlist set pw=#{pw}, name=#{name}, sex=#{sex}, age=#{age}, img=#{img}")
	    int updateUser(UserVO user);
	    
	    @Select("select * from userlist where id='${id}' and pw='${pw}'")
	    UserVO login(HashMap<String , String> map);
	    
	    @Select("select * from userlist where id=#{id}")
	    UserVO getUser(String id);
	    
	    @Delete("delete from userlist where id=#{id}")
	    int removeUser(String id);
	    
	    @Select("select * from userlist")
		List<UserVO> getUserList();
		
	    @Insert("insert into friend(id, fid) values('${id}', '${fid}')")
	    int addFriend(HashMap<String , String> map);
	    
	    @Delete("delete from friend where id=${id} and fid=${fid}")
		int removeFriend(HashMap<String, String> map);
	    
	    @Select("select * from friend where id=#{id}")
		List<FriendVO> getFriendList(String id);
		
	    @Insert("insert into checkbox(id, why, stime, etime, ppnum, nownum, color, msg) values(#{id}, '#'||(select name from userlist where id=#{id})||#{why}, #{stime}, #{etime}, #{ppnum}, #{nownum}, #{color}, #{msg})")
		int addCheckContent(CheckVO content);
	    
	    @Delete("delete from checkbox where id=#{id}")
		int removeCheckContent(String id);
	    
	    @Update("update checkbox set id=#{id}, why=#{why}, stime=#{stime}, etime=#{etime}, ppnum=#{ppnum}, nownum=#{nownum}, color=#{color}, msg=#{msg}")
		int updateCheckContent(CheckVO content);
	    
	    @Select("select id, why, to_char(stime, 'yyyy.mm.dd hh:mi:ss') as stime, to_char(etime, 'yyyy.mm.dd hh:mi:ss') as etime, ppnum, nownum, color, msg from checkbox")
	    List<CheckVO> getCheckContentList();
	    
	    @Select("select * from checkbox where id=#{id}")
		CheckVO getCheckContent(String id);
	    
	    @Select("select * from v3 where id=#{id}")
	    ViewVO getView(String id);
	    
		@SelectProvider(type = dynamic.DynamicSql.class, method = "searchFriends")
		List<ViewVO> searchFriends(@Param("id") String id, @Param("condition") String condition);
		
		@Select("select * from v3 where id in (select fid from friend where id=#{id})")
		List<ViewVO> getFriendViewList(String id);
		
		@Insert("insert into mailbox(num, id, fid, why, msg) values((select nvl(max(num),0)+1 from mailbox), #{id}, #{fid}, #{why}, #{msg})")
		int sendMail(MailVO mail);
		
		@Select("select * from mailbox where num=#{num}")
		MailVO getMail(int num);
		
	    @Select("select img from userlist where id=#{id}")
	    UserVO getUserImg(String id);
		
		int friendConfirm(MailVO mail);
		int meetConfirm(MailVO mail);
		int cancle(MailVO mail); /////dao, service 수정 필요,,,,,MailVO mail --> String num

}



