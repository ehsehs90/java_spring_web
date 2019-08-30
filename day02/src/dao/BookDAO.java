package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO {
	public List<BookVO> bookList(){
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book order by bookno";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getInt("price"));
				book.setBookno(rs.getInt("bookno"));
				book.setPubdate(rs.getDate("pubdate").toString());
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}
	
	public int addBook(BookVO vo) throws Exception {
		String sql = "insert into book(bookno,title,author,price) " + 
				"values((select nvl(max(bookno),0)+1 from book) , ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getAuthor());
			ps.setInt(3, vo.getPrice());
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			//System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}
	
	public int deleteBook(String bookno) throws Exception {
		String sql = "delete from book where bookno=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bookno);
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}
}
