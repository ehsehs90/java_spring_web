package spring;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.JDBCUtil;

public class Test01_JdbcUtil {
	Connection con;
	
	@Before
	public void setUp() {
		con = JDBCUtil.getConnection();
		System.out.println("Assigned con");
	}
	
	@After
	public void tearDown() {
		JDBCUtil.close(con, null, null);
		System.out.println("released con");
	}
	
	@Test
	public void test() {
		assertNotNull(con);
	}

}
