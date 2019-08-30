//package spring.biz.board.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import spring.biz.board.vo.BoardVO;
//import util.JDBCUtil;
//
//@Component("boardjdbc")
//public class BoardDAO_JDBC implements BoardDAO {
//
//	@Override
//	public int insertBoard(BoardVO vo) {
//		String sql = "insert into board values(?, ?, ?, ?)";
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		int row = 0;
//		try {
//			con = JDBCUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, vo.getSeq());
//			ps.setString(2, vo.getTitle());
//			ps.setString(3, vo.getWriter());
//			ps.setString(4, vo.getContent());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	@Override
//	public int updateBoard(BoardVO vo) {
//		String sql;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		int row = 0;
//		return 0;
//	}
//
//	@Override
//	public BoardVO getBoard(int number) {
//		String sql;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		int row = 0;
//		return null;
//	}
//
//	@Override
//	public List<BoardVO> getBoardList() {
//		String sql;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		int row = 0;
//		return null;
//	}
//
//	@Override
//	public int deleteBoard(int seq) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//}
