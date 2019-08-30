package spring.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

@Component("boardspring")
public class BoardDAO_Spring implements BoardDAO{

	@Autowired
	private JdbcTemplate template = null;
	
	@Override
	public int insertBoard(BoardVO vo) {
		String sql = "insert into board(seq, title, writer, content) values(?,?,?,?)";
		return template.update(sql, new Object[] {
				vo.getSeq(),
				vo.getTitle(),
				vo.getWriter(),
				vo.getContent()
		});
	}

	@Override
	public int updateBoard(BoardVO vo) {
		String sql = "update board set title=?, writer=?, content=? where seq=?";
		return template.update(sql, new Object[] {
				vo.getTitle(),
				vo.getWriter(),
				vo.getContent(),
				vo.getSeq()
		});
	}

	@Override
	public int deleteBoard(int seq) {
		String sql = "delete from board where seq=?";
		return template.update(sql, new Object[] {seq});
	}
	
	@Override
	public BoardVO getBoard(int seq) {
		String sql = "select * from board where seq=?";
		return template.queryForObject(sql, new Object[] {seq}, new BoardRowMapper());
	}

	@Override
	public List<BoardVO> getBoardList() {
		String sql = "select * from board";
		return template.query(sql, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setCnt(rs.getInt("cnt"));
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getDate("regdate"));
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		return vo;
	}
	
}
