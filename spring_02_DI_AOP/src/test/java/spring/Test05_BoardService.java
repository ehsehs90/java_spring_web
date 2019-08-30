package spring;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.board.service.BoardService;
import spring.biz.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test05_BoardService {

	@Autowired
	BoardService service;

	@Test
	public void list() {
		for(BoardVO vo:service.getBoardList()) {
			System.out.println(vo);
		}
	}
	
	//@Test
	public void insert() {
		BoardVO board = new BoardVO(
				"test title",
				"pail",
				"this is content ~~~~"
				);
		System.out.println(service.insertBoard(board));
	}
	//@Test
	public void update() {
		BoardVO board = service.getBoard(2);
		board.setTitle("none");
		System.out.println(service.updateBoard(board));
	}
	//@Test
	public void getBoard() {
		System.out.println(service.getBoard(2));
	}
	//@Test
	public void deleteBoard() {
		System.out.println(service.deleteBoard(2));
	}

}
