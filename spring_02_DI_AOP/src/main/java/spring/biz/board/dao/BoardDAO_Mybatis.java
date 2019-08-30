package spring.biz.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.board.vo.BoardVO;

@Component("boardmybatis")
public class BoardDAO_Mybatis implements BoardDAO{

	@Resource(name="sqlSession2")
	private SqlSession sqlsession = null;
	
	@Override
	public int insertBoard(BoardVO vo) {
		return sqlsession.insert("board.insert", vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return sqlsession.update("board.update", vo);
	}

	@Override
	public BoardVO getBoard(int seq) {
		return sqlsession.selectOne("board.getboard", seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return sqlsession.selectList("board.list");
	}

	@Override
	public int deleteBoard(int seq) {
		return sqlsession.delete("board.delete", seq);
	}

}
